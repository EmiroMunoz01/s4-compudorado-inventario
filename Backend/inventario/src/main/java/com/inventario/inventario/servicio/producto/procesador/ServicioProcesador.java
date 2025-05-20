package com.inventario.inventario.servicio.producto.procesador;


import com.inventario.inventario.DTO.producto.procesador.ActualizarProcesador;
import com.inventario.inventario.DTO.producto.procesador.CrearProcesador;
import com.inventario.inventario.DTO.producto.procesador.ObtenerProcesador;
import com.inventario.inventario.modelo.producto.Procesador;
import com.inventario.inventario.repositorio.producto.RepositorioProcesador;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioProcesador implements IProcesador {

    private final RepositorioProcesador repositorioProcesador;

    public ServicioProcesador(RepositorioProcesador repositorioProcesador) {
        this.repositorioProcesador = repositorioProcesador;
    }

    private ObtenerProcesador convertirProcesadorEnDTO(Procesador procesador) {

        ObtenerProcesador procesadorDTO = new ObtenerProcesador();
        procesadorDTO.setNombre(procesador.getNombre());
        procesadorDTO.setDescripcion(procesador.getDescripcion());
        procesadorDTO.setMarca(procesador.getMarca());
        procesadorDTO.setSku(procesador.getSku());
        procesadorDTO.setSocketProcesador(procesador.getSocketProcesador());
        procesadorDTO.setFechaCreacion(procesador.getFechaCreacion());

        return procesadorDTO;
    }


    @Override
    public List<ObtenerProcesador> listarTodosProcesadores() {
        return repositorioProcesador.findAll().stream().map(this::convertirProcesadorEnDTO).toList();
    }

    @Override
    public List<ObtenerProcesador> listarProcesadoresPorNombre(String nombreProcesador) {
        List<Procesador> procesadores = repositorioProcesador.findProcesadorByNombreContainingIgnoreCase(nombreProcesador);

        // Convertimos la lista de Procesador a una lista de ObtenerProcesador
        return procesadores
                .stream()
                .map(this::convertirProcesadorEnDTO)
                .toList();
    }


    @Override
    public ObtenerProcesador buscarProcesadorPorSKU(String sku) {
        Procesador procesador = repositorioProcesador.findProcesadorBySku(sku).orElseThrow(() -> new EntityNotFoundException("Procesador no encontrado con SKU: " + sku));

        return convertirProcesadorEnDTO(procesador);
    }

    @Override
    public ObtenerProcesador crearProcesador(CrearProcesador crearProcesador) {

        if (repositorioProcesador.existsProcesadorBySku(crearProcesador.getSku())) {
            throw new EntityExistsException("El identificador SKU: " + crearProcesador.getSku() + " ya existe.");
        }

        Procesador procesador = new Procesador();

        procesador.setNombre(crearProcesador.getNombre());
        procesador.setDescripcion(crearProcesador.getDescripcion());
        procesador.setMarca(crearProcesador.getMarca());
        procesador.setSku(crearProcesador.getSku());
        procesador.setSocketProcesador(crearProcesador.getSocketProcesador());
        procesador.setFechaCreacion(LocalDateTime.now());

        repositorioProcesador.save(procesador);

        return convertirProcesadorEnDTO(procesador);
    }

    @Override
    public ObtenerProcesador actualizarProcesador(String sku, ActualizarProcesador procesador) {

        //iniciaremos buscando la entidad, si no la encontramos desplegaremos el error.
        Procesador buscarProcesador = repositorioProcesador.findProcesadorBySku(sku).orElseThrow(() -> new EntityNotFoundException("Procesador no encontrado con sku: " + sku));

        //si lo encontramos procederemos a la modificacion de los campos del procesador que se quiere actualizar

        buscarProcesador.setNombre(procesador.getNombre());
        buscarProcesador.setDescripcion(procesador.getDescripcion());
        buscarProcesador.setMarca(procesador.getMarca());
        buscarProcesador.setSku(procesador.getSku());
        buscarProcesador.setSocketProcesador(procesador.getSocketProcesador());

        //guardaremos los cambios
        repositorioProcesador.save(buscarProcesador);

        //haremos la conversion al DTO que devolveremos como respuesta

        return convertirProcesadorEnDTO(buscarProcesador);
    }

    @Override
    public Procesador eliminarProcesadorPorSKU(String sku) {

        Procesador procesador = repositorioProcesador.findProcesadorBySku(sku).orElseThrow(() -> new EntityNotFoundException("Procesador no encontrado con SKU: " + sku));

        repositorioProcesador.delete(procesador);

        return procesador;

    }

}

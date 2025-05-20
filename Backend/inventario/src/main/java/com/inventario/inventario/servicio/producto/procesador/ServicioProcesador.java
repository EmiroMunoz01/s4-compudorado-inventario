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

@Service
public class ServicioProcesador implements IProcesador {

    private final RepositorioProcesador repositorioProcesador;

    public ServicioProcesador(RepositorioProcesador repositorioProcesador) {
        this.repositorioProcesador = repositorioProcesador;
    }

    @Override
    public List<ObtenerProcesador> listarTodosProcesadores() {
        return List.of();
    }

    @Override
    public List<ObtenerProcesador> listarProcesadoresPorNombre(String nombreProcesador) {
        return List.of();
    }

    @Override
    public ObtenerProcesador buscarProcesadorPorSKU(String sku) {
        return null;
    }

    @Override
    public ObtenerProcesador crearProcesador(CrearProcesador crearProcesador) {

       if(repositorioProcesador.existsProcesadorBySku(crearProcesador.getSku())){
           throw new EntityExistsException("El identificador SKU: "+ crearProcesador.getSku() +" ya existe.");
       }

        Procesador procesador = new Procesador();

        procesador.setNombre(crearProcesador.getNombre());
        procesador.setDescripcion(crearProcesador.getDescripcion());
        procesador.setMarca(crearProcesador.getMarca());
        procesador.setSku(crearProcesador.getSku());
        procesador.setSocketProcesador(crearProcesador.getSocketProcesador());
        procesador.setFechaCreacion(LocalDateTime.now());

        repositorioProcesador.save(procesador);

        return null;
    }

    @Override
    public ActualizarProcesador actualizarProcesador(String sku, ActualizarProcesador procesador) {
        return null;
    }

    @Override
    public Procesador eliminarProcesadorPorSKU(String sku) {

        Procesador procesador = repositorioProcesador
                .findProcesadorBySku(sku)
                .orElseThrow(() -> new EntityNotFoundException("Procesador no encontrado con SKU: " + sku));

        repositorioProcesador.delete(procesador);

        return procesador;

    }

}

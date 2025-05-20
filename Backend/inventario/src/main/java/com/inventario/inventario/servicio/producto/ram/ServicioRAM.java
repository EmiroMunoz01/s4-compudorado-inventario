package com.inventario.inventario.servicio.producto.ram;

import com.inventario.inventario.DTO.producto.procesador.ObtenerProcesador;
import com.inventario.inventario.DTO.producto.ram.ActualizarRAM;
import com.inventario.inventario.DTO.producto.ram.CrearRAM;
import com.inventario.inventario.DTO.producto.ram.ObtenerRAM;
import com.inventario.inventario.modelo.producto.MemoriaRAM;
import com.inventario.inventario.modelo.producto.Procesador;
import com.inventario.inventario.repositorio.producto.RepositorioProcesador;
import com.inventario.inventario.repositorio.producto.RepositorioRAM;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicioRAM implements IRAM {

    private final RepositorioRAM repositorioRAM;

    public ServicioRAM(RepositorioRAM repositorioRAM) {
        this.repositorioRAM = repositorioRAM;
    }


    private ObtenerRAM convertirRAMEnDTO(MemoriaRAM memoriaRAM) {

        ObtenerRAM ramDTO = new ObtenerRAM();

        ramDTO.setNombre(memoriaRAM.getNombre());
        ramDTO.setDescripcion(memoriaRAM.getDescripcion());
        ramDTO.setMarca(memoriaRAM.getMarca());
        ramDTO.setSku(memoriaRAM.getSku());
        ramDTO.setCapacidad(memoriaRAM.getCapacidad());
        ramDTO.setVelocidad(memoriaRAM.getVelocidad());
        ramDTO.setTecnologiaRAM(memoriaRAM.getTecnologiaRAM());

        ramDTO.setFechaCreacion(memoriaRAM.getFechaCreacion());

        return ramDTO;
    }


    @Override
    public List<ObtenerRAM> listarTodaMemoriaRAM() {
        return repositorioRAM.findAll().stream().map(this::convertirRAMEnDTO).toList();
    }

    @Override
    public List<ObtenerRAM> listarMemoriaRAMPorNombre(String nombreMemoriaRAM) {
        List<MemoriaRAM> memoriaRAMS = repositorioRAM.findMemoriaRAMByNombreContainingIgnoreCase(nombreMemoriaRAM);

        // Convertimos la lista de Ram a una lista de ObtenerRAM
        return memoriaRAMS.stream().map(this::convertirRAMEnDTO).toList();
    }

    @Override
    public ObtenerRAM buscarMemoriaRAMPorSKU(String sku) {
        MemoriaRAM ram = repositorioRAM.findMemoriaRAMBySku(sku).orElseThrow(() -> new EntityNotFoundException("RAM no encontrado con SKU: " + sku));

        return convertirRAMEnDTO(ram);
    }

    @Override
    public ObtenerRAM crearMemoriaRAM(CrearRAM crearMemoriaRAM) {

        if (repositorioRAM.existsMemoriaRAMBySku(crearMemoriaRAM.getSku())) {
            throw new EntityExistsException("El identificador SKU: " + crearMemoriaRAM.getSku() + " ya existe.");
        }

        MemoriaRAM ram = new MemoriaRAM();

        ram.setNombre(crearMemoriaRAM.getNombre());
        ram.setDescripcion(crearMemoriaRAM.getDescripcion());
        ram.setMarca(crearMemoriaRAM.getMarca());
        ram.setSku(crearMemoriaRAM.getSku());
        ram.setCapacidad(crearMemoriaRAM.getCapacidad());
        ram.setVelocidad(crearMemoriaRAM.getVelocidad());
        ram.setTecnologiaRAM(crearMemoriaRAM.getTecnologiaRAM());

        ram.setFechaCreacion(LocalDateTime.now());

        repositorioRAM.save(ram);

        return convertirRAMEnDTO(ram);
    }

    @Override
    public ObtenerRAM actualizarMemoriaRAM(String sku, ActualizarRAM memoriaRAM) {
        //iniciaremos buscando la entidad, si no la encontramos desplegaremos el error.
        MemoriaRAM buscarRAM = repositorioRAM.findMemoriaRAMBySku(sku).orElseThrow(() -> new EntityNotFoundException("Procesador no encontrado con sku: " + sku));

        //si lo encontramos procederemos a la modificacion de los campos de la memoria ram que se quiere actualizar

        buscarRAM.setNombre(memoriaRAM.getNombre());
        buscarRAM.setDescripcion(memoriaRAM.getDescripcion());
        buscarRAM.setMarca(memoriaRAM.getMarca());
        buscarRAM.setSku(memoriaRAM.getSku());

        buscarRAM.setCapacidad(memoriaRAM.getCapacidad());
        buscarRAM.setVelocidad(memoriaRAM.getVelocidad());
        buscarRAM.setTecnologiaRAM(memoriaRAM.getTecnologiaRAM());

        //guardaremos los cambios
        repositorioRAM.save(buscarRAM);

        //haremos la conversion al DTO que devolveremos como respuesta
        return convertirRAMEnDTO(buscarRAM);
    }

    @Override
    public MemoriaRAM eliminarMemoriaRAMPorSKU(String sku) {

        MemoriaRAM ram = repositorioRAM.findMemoriaRAMBySku(sku).orElseThrow(() -> new EntityNotFoundException("MemoriaRAM no encontrada con SKU: " + sku));

        repositorioRAM.delete(ram);

        return ram;
    }

}

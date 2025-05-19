package com.inventario.inventario.servicio.proveedor;


import com.inventario.inventario.DTO.proveedor.ActualizarProveedor;
import com.inventario.inventario.DTO.proveedor.CrearProveedor;
import com.inventario.inventario.DTO.proveedor.ObtenerProveedor;
import com.inventario.inventario.modelo.compra.Proveedor;
import com.inventario.inventario.repositorio.RepositorioProveedor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioProveedor implements IProveedor {


    //estamos inyectando la dependencia mediante la utilizacion de un constructor

    private final RepositorioProveedor repositorioProveedor;

    public ServicioProveedor(RepositorioProveedor repositorioProveedor) {
        this.repositorioProveedor = repositorioProveedor;
    }

    private ObtenerProveedor convertirAObtenerProveedorDTO(Proveedor proveedor) {

        ObtenerProveedor dto = new ObtenerProveedor();
        dto.setNombre(proveedor.getNombre());
        dto.setEmail(proveedor.getEmail());
        dto.setFechaCreacion(proveedor.getFechaCreacion());
        return dto;

    }

    @Override
    public List<ObtenerProveedor> listarProveedores() {
        return repositorioProveedor.findAll()
                .stream()
                .map(this::convertirAObtenerProveedorDTO)
                .toList();
    }

    @Override
    public ObtenerProveedor crearProveedor(CrearProveedor proveedor) {

        Proveedor nuevoProveedor = new Proveedor();
        nuevoProveedor.setNombre(proveedor.getNombre());
        nuevoProveedor.setEmail(proveedor.getEmail());
        nuevoProveedor.setFechaCreacion(LocalDateTime.now());

        repositorioProveedor.save(nuevoProveedor);

        ObtenerProveedor respuesta = new ObtenerProveedor();

        respuesta.setNombre(nuevoProveedor.getNombre());
        respuesta.setEmail(nuevoProveedor.getEmail());
        respuesta.setFechaCreacion(nuevoProveedor.getFechaCreacion());

        return respuesta;

    }

    @Override
    public ObtenerProveedor actualizarProveedor(String email, ActualizarProveedor proveedor) {

        Proveedor buscar = repositorioProveedor.findProveedorByEmail(email).orElseThrow(() -> new EntityNotFoundException("Proveedor no encontrado con email: " + email));

        buscar.setNombre(proveedor.getNombre());
        repositorioProveedor.save(buscar);


        ObtenerProveedor respuesta = new ObtenerProveedor();

        respuesta.setNombre(buscar.getNombre());
        respuesta.setEmail(buscar.getEmail());
        respuesta.setFechaCreacion(buscar.getFechaCreacion());

        return respuesta;

    }

    @Override
    public ObtenerProveedor buscarProveedorPorEmail(String email) {

        Proveedor buscar = repositorioProveedor.findProveedorByEmail(email).orElseThrow(() -> new EntityNotFoundException("Proveedor no encontrado con email: " + email));

        ObtenerProveedor proveedorEncontrado = new ObtenerProveedor();

        proveedorEncontrado.setNombre(buscar.getNombre());
        proveedorEncontrado.setEmail(buscar.getEmail());
        proveedorEncontrado.setFechaCreacion(buscar.getFechaCreacion());

        return proveedorEncontrado;
    }

    @Override
    public Proveedor eliminarProveedorPorEmail(String email) {
        Proveedor proveedor = repositorioProveedor
                .findProveedorByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Proveedor no encontrado con email: " + email));

        repositorioProveedor.delete(proveedor);

        return proveedor;
    }

}

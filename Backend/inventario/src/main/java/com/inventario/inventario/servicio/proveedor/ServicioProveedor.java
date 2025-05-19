package com.inventario.inventario.servicio.proveedor;


import com.inventario.inventario.DTO.proveedor.ActualizarProveedor;
import com.inventario.inventario.DTO.proveedor.CrearProveedor;
import com.inventario.inventario.DTO.proveedor.ObtenerProveedor;
import com.inventario.inventario.modelo.compra.Proveedor;
import com.inventario.inventario.repositorio.ProveedorRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicioProveedor implements IProveedor {


    //estamos inyectando la dependencia mediante la utilizacion de un constructor

    private final ProveedorRepositorio proveedorRepositorio;

    public ServicioProveedor(ProveedorRepositorio proveedorRepositorio) {
        this.proveedorRepositorio = proveedorRepositorio;
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
        return proveedorRepositorio.findAll()
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

        proveedorRepositorio.save(nuevoProveedor);

        ObtenerProveedor respuesta = new ObtenerProveedor();

        respuesta.setNombre(nuevoProveedor.getNombre());
        respuesta.setEmail(nuevoProveedor.getNombre());
        respuesta.setFechaCreacion(nuevoProveedor.getFechaCreacion());

        return respuesta;

    }

    @Override
    public ActualizarProveedor actualizarProveedor(String email, ActualizarProveedor proveedor) {
        return null;
    }

    @Override
    public ObtenerProveedor buscarProveedorPorEmail(String email) {
        return null;
    }

    @Override
    public void eliminarProveedorPorEmail(String email) {

    }
}

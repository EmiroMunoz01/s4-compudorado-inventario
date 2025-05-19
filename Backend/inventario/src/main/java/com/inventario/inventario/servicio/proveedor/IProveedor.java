package com.inventario.inventario.servicio.proveedor;

import com.inventario.inventario.DTO.proveedor.ActualizarProveedor;
import com.inventario.inventario.DTO.proveedor.CrearProveedor;
import com.inventario.inventario.DTO.proveedor.ObtenerProveedor;
import com.inventario.inventario.modelo.compra.Proveedor;

import java.util.List;

public interface IProveedor {

    List<ObtenerProveedor> listarProveedores();

    public ObtenerProveedor crearProveedor(CrearProveedor proveedor);

    public ActualizarProveedor actualizarProveedor(String email, ActualizarProveedor proveedor);

    public ObtenerProveedor buscarProveedorPorEmail(String email);

    void eliminarProveedorPorEmail(String email);
}

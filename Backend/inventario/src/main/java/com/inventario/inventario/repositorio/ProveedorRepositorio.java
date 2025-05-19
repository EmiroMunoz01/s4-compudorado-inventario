package com.inventario.inventario.repositorio;

import com.inventario.inventario.modelo.compra.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepositorio extends JpaRepository<Long, Proveedor> {
}

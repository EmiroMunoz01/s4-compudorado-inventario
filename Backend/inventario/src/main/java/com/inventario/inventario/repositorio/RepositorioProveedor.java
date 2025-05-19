package com.inventario.inventario.repositorio;

import com.inventario.inventario.modelo.compra.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioProveedor extends JpaRepository<Proveedor, Long> {

    Optional<Proveedor> findProveedorByEmail(String email);

    void deleteByEmail(String email);

}

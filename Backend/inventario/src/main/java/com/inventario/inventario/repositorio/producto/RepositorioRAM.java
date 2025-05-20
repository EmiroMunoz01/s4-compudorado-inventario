package com.inventario.inventario.repositorio.producto;


import com.inventario.inventario.modelo.producto.MemoriaRAM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRAM extends JpaRepository<MemoriaRAM, Long> {



}

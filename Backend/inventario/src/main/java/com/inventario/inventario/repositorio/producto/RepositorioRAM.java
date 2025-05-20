package com.inventario.inventario.repositorio.producto;


import com.inventario.inventario.modelo.producto.MemoriaRAM;
import com.inventario.inventario.modelo.producto.Procesador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioRAM extends JpaRepository<MemoriaRAM, Long> {

    //Listar MemoriaRAM por coincidencia de nombre
    List<MemoriaRAM> findMemoriaRAMByNombreContainingIgnoreCase(String nombre);

    //Buscar MemoriaRAM por SKU
    Optional<MemoriaRAM> findMemoriaRAMBySku(String sku);

    //Verificamos la existencia de la MemoriaRAM mediante el booleano que buscara la sentencia en la tabla de procesadores
    boolean existsMemoriaRAMBySku(String sku);

}

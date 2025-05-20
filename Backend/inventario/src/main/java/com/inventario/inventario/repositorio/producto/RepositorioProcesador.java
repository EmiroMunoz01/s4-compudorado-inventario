package com.inventario.inventario.repositorio.producto;

import com.inventario.inventario.modelo.producto.Procesador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioProcesador extends JpaRepository<Procesador, Long> {

    //Listar procesadores por coincidencia de nombre
    List<Procesador> findProcesadorByNombreContainingIgnoreCase(String nombre);

    //Buscar procesador por SKU
    Optional<Procesador> findProcesadorBySku(String sku);


    //Verificamos la existencia del procesador mediante el booleano que buscara la sentencia en la tabla de procesadores
    boolean existsProcesadorBySku(String sku);


}

package com.inventario.inventario.servicio.producto.procesador;


import com.inventario.inventario.DTO.producto.procesador.ActualizarProcesador;
import com.inventario.inventario.DTO.producto.procesador.CrearProcesador;
import com.inventario.inventario.DTO.producto.procesador.ObtenerProcesador;
import com.inventario.inventario.modelo.producto.Procesador;

import java.util.List;

public interface IProcesador {

    List<ObtenerProcesador> listarTodosProcesadores();

    List<ObtenerProcesador> listarProcesadoresPorNombre(String nombreProcesador);

    public ObtenerProcesador buscarProcesadorPorSKU(String sku);

    public ObtenerProcesador crearProcesador(CrearProcesador crearProcesador);

    public ObtenerProcesador actualizarProcesador(String sku, ActualizarProcesador procesador);

    public Procesador eliminarProcesadorPorSKU(String sku);
}

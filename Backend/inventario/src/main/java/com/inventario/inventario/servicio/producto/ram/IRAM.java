package com.inventario.inventario.servicio.producto.ram;



import com.inventario.inventario.DTO.producto.ram.ActualizarRAM;
import com.inventario.inventario.DTO.producto.ram.CrearRAM;
import com.inventario.inventario.DTO.producto.ram.ObtenerRAM;
import com.inventario.inventario.modelo.producto.MemoriaRAM;

import java.util.List;

public interface IRAM {


    List<ObtenerRAM> listarTodaMemoriaRAM();

    List<ObtenerRAM> listarMemoriaRAMPorNombre(String nombreMemoriaRAM);

    public ObtenerRAM buscarMemoriaRAMPorSKU(String sku);

    public ObtenerRAM crearMemoriaRAM(CrearRAM crearMemoriaRAM);

    public ObtenerRAM actualizarMemoriaRAM(String sku, ActualizarRAM MemoriaRAM);

    public MemoriaRAM eliminarMemoriaRAMPorSKU(String sku);

}

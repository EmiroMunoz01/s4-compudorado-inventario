package com.inventario.inventario.DTO.producto.procesador;

import com.inventario.inventario.modelo.producto.enums.ProcesadorSocket;
import com.inventario.inventario.modelo.producto.enums.ProductoMarca;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActualizarProcesador {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 4, message = "El nombre debe tener al menos 4 caracteres")
    private String nombre;

    @NotBlank(message = "La descripcion no puede estar vacío")
    @Size(min = 4, message = "La descripcion debe tener al menos 4 caracteres")
    private String descripcion;

    @NotNull(message = "La marca no puede estar vacía")
    private ProductoMarca marca;

    @NotBlank(message = "El sku no puede estar vacío")
    @Size(min = 4, message = "El sku debe tener al menos 4 caracteres")
    private String sku; // Código único del producto

    @NotNull(message = "El socket no puede estar vacío")
    private ProcesadorSocket socketProcesador;

}

package com.inventario.inventario.DTO.producto.procesador;

import com.inventario.inventario.modelo.producto.enums.ProcesadorSocket;
import com.inventario.inventario.modelo.producto.enums.ProductoMarca;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ObtenerProcesador {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 4, message = "El nombre debe tener al menos 4 caracteres")
    private String nombre;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 4, message = "El nombre debe tener al menos 4 caracteres")
    private String descripcion;

    @NotNull(message = "La marca no puede estar vacía")
    private ProductoMarca marca;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 4, message = "El nombre debe tener al menos 4 caracteres")
    private String sku; // Código único del producto

    @NotNull(message = "El socket no puede estar vacío")
    private ProcesadorSocket socketProcesador;

    private LocalDateTime fechaCreacion;

}

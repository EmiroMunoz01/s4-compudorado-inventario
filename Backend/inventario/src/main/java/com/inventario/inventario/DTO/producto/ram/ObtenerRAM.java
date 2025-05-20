package com.inventario.inventario.DTO.producto.ram;

import com.inventario.inventario.modelo.producto.enums.ProductoMarca;
import com.inventario.inventario.modelo.producto.enums.RAMTecnologia;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ObtenerRAM {

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

    @NotNull(message = "La capacidad no puede estar vacía")
    private int capacidad;

    @NotNull(message = "La velocidad no puede estar vacía")
    private Double velocidad;

    @NotNull(message = "La tecnologiaRAM no puede estar vacía")
    private RAMTecnologia tecnologiaRAM;

    private LocalDateTime fechaCreacion;

}

package com.inventario.inventario.DTO.proveedor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ObtenerProveedor {


    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 4, message = "El nombre debe tener al menos 4 caracteres")
    private String nombre;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El correo electrónico no es válido.")
    private String email;

    private LocalDateTime fechaCreacion;

}

package com.inventario.inventario.modelo.producto;


import com.inventario.inventario.modelo.producto.enums.ProcesadorSocket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@PrimaryKeyJoinColumn(name = "producto_id")
@Table(name = "entidad_procesador")
public class Procesador extends Producto {

    @Enumerated(EnumType.STRING)
    @Column(name = "socket", nullable = false)
    private ProcesadorSocket socketProcesador;

}

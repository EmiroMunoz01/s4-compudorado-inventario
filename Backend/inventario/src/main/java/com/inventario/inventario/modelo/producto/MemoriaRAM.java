package com.inventario.inventario.modelo.producto;

import com.inventario.inventario.modelo.producto.enums.RAMTecnologia;
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
@Table(name = "entidad_memoria_ram")
public class MemoriaRAM extends Producto {

    @Column(name = "capacidad", nullable = false)
    private int capacidad;

    @Column(name = "velocidad", nullable = false)
    private Double velocidad;

    @Column(name = "tecnologia_ram", nullable = false)
    @Enumerated(EnumType.STRING)
    private RAMTecnologia tecnologiaRAM;

}

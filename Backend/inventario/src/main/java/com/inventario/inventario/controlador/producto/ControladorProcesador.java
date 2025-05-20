package com.inventario.inventario.controlador.producto;


import com.inventario.inventario.DTO.producto.procesador.ActualizarProcesador;
import com.inventario.inventario.DTO.producto.procesador.CrearProcesador;
import com.inventario.inventario.servicio.producto.procesador.ServicioProcesador;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compudorado/producto/procesador")
public class ControladorProcesador {

    private final ServicioProcesador servicioProcesador;

    public ControladorProcesador(ServicioProcesador servicioProcesador) {
        this.servicioProcesador = servicioProcesador;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarProcesador() {
        return ResponseEntity.ok(servicioProcesador.listarTodosProcesadores());
    }

    @GetMapping("/buscar-sku/{sku}")
    public ResponseEntity<?> listarProcesadorPorSKU(@PathVariable String sku) {
        return ResponseEntity.ok(servicioProcesador.buscarProcesadorPorSKU(sku));
    }

    @GetMapping("/buscar-nombre/{nombre}")
    public ResponseEntity<?> listarProcesadorPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(servicioProcesador.listarProcesadoresPorNombre(nombre));
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearProcesador(@Valid @RequestBody CrearProcesador crearProcesador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioProcesador.crearProcesador(crearProcesador));
    }

    @DeleteMapping("/eliminar/{sku}")
    public ResponseEntity<?> eliminarProcesador(@PathVariable String sku) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicioProcesador.eliminarProcesadorPorSKU(sku));
    }

    @PutMapping("/actualizar/{sku}")
    public ResponseEntity<?> actualizarProcesador(@PathVariable String sku, @Valid @RequestBody ActualizarProcesador Procesador) {
        return ResponseEntity.status(HttpStatus.OK).body(servicioProcesador.actualizarProcesador(sku, Procesador));
    }

}

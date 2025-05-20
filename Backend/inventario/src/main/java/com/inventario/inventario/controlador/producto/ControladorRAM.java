package com.inventario.inventario.controlador.producto;


import com.inventario.inventario.DTO.producto.ram.ActualizarRAM;
import com.inventario.inventario.DTO.producto.ram.CrearRAM;
import com.inventario.inventario.servicio.producto.ram.ServicioRAM;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compudorado/producto/ram")
public class ControladorRAM {

    private final ServicioRAM servicioRAM;

    public ControladorRAM(ServicioRAM servicioRAM) {
        this.servicioRAM = servicioRAM;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarMemoriaRAM() {
        return ResponseEntity.ok(servicioRAM.listarTodaMemoriaRAM());
    }

    @GetMapping("/buscar-sku/{sku}")
    public ResponseEntity<?> listarMemoriaRAMPorSKU(@PathVariable String sku) {
        return ResponseEntity.ok(servicioRAM.buscarMemoriaRAMPorSKU(sku));
    }

    @GetMapping("/buscar-nombre/{nombre}")
    public ResponseEntity<?> listarMemoriaRAMPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(servicioRAM.listarMemoriaRAMPorNombre(nombre));
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearMemoriaRAM(@Valid @RequestBody CrearRAM crearMemoriaRAM) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioRAM.crearMemoriaRAM(crearMemoriaRAM));
    }

    @DeleteMapping("/eliminar/{sku}")
    public ResponseEntity<?> eliminarMemoriaRAM(@PathVariable String sku) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicioRAM.eliminarMemoriaRAMPorSKU(sku));
    }

    @PutMapping("/actualizar/{sku}")
    public ResponseEntity<?> actualizarMemoriaRAM(@PathVariable String sku, @Valid @RequestBody ActualizarRAM MemoriaRAM) {
        return ResponseEntity.status(HttpStatus.OK).body(servicioRAM.actualizarMemoriaRAM(sku, MemoriaRAM));
    }

}

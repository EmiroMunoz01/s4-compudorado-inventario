package com.inventario.inventario.controlador;


import com.inventario.inventario.DTO.proveedor.ActualizarProveedor;
import com.inventario.inventario.DTO.proveedor.CrearProveedor;
import com.inventario.inventario.servicio.proveedor.ServicioProveedor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compudorado/proveedor")

public class ControladorProveedor {

    private final ServicioProveedor servicioProveedor;

    public ControladorProveedor(ServicioProveedor servicioProveedor) {
        this.servicioProveedor = servicioProveedor;
    }


    @GetMapping("/listar")
    public ResponseEntity<?> listarProveedor() {
        return ResponseEntity.ok(servicioProveedor.listarProveedores());
    }

    @GetMapping("/buscar/{email}")
    public ResponseEntity<?> listarProveedorPorEmail(@PathVariable String email) {
        return ResponseEntity.ok(servicioProveedor.buscarProveedorPorEmail(email));
    }


    @PostMapping("/crear")
    public ResponseEntity<?> crearProveedor(@Valid @RequestBody CrearProveedor crearProveedor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioProveedor.crearProveedor(crearProveedor));
    }

    @DeleteMapping("/eliminar/{email}")
    public ResponseEntity<?> eliminarProveedor(@PathVariable String email) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicioProveedor.eliminarProveedorPorEmail(email));
    }


    @PutMapping("/actualizar/{email}")
    public ResponseEntity<?> actualizarProveedor( @PathVariable String email, @Valid ActualizarProveedor proveedor){
        return ResponseEntity.status(HttpStatus.OK).body(servicioProveedor.actualizarProveedor(email,proveedor));
    }

}

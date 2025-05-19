package com.inventario.inventario.controlador;


import com.inventario.inventario.DTO.proveedor.CrearProveedor;
import com.inventario.inventario.servicio.proveedor.ServicioProveedor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compudorado/proveedor")

public class ProveedorServicio {

    private final ServicioProveedor servicioProveedor;

    public ProveedorServicio (ServicioProveedor servicioProveedor){
        this.servicioProveedor = servicioProveedor;
    }


    @GetMapping("/listar")
    public  ResponseEntity<?> listarUsuarios(){
        return ResponseEntity.ok(servicioProveedor.listarProveedores()) ;
    }


    @PostMapping("/crear")
    public ResponseEntity<?> crearProveedor(@Valid @RequestBody CrearProveedor crearProveedor){
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioProveedor.crearProveedor(crearProveedor));
    }



}

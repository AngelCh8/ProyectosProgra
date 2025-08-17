package com.umg.banco.controller;

import com.umg.banco.entity.Transaccion;
import com.umg.banco.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    // Crear transacción
    @PostMapping
    public Transaccion crearTransaccion(@RequestBody Transaccion transaccion) {
        return transaccionService.crearTransaccion(transaccion);
    }

    // Listar todas las transacciones
    @GetMapping
    public List<Transaccion> listarTransacciones() {
        return transaccionService.listarTransacciones();
    }

    // Buscar transacción por ID
    @GetMapping("/{id}")
    public Transaccion obtenerTransaccionPorId(@PathVariable Long id) {
        return transaccionService.obtenerTransaccionPorId(id);
    }

    // Actualizar transacción
    @PutMapping("/{id}")
    public Transaccion actualizarTransaccion(@PathVariable Long id, @RequestBody Transaccion transaccion) {
        return transaccionService.actualizarTransaccion(id, transaccion);
    }

    // Eliminar transacción
    @DeleteMapping("/{id}")
    public String eliminarTransaccion(@PathVariable Long id) {
        transaccionService.eliminarTransaccion(id);
        return "Transacción eliminada con éxito.";
    }
}

package com.umg.banco.controller;

import com.umg.banco.entity.Cuenta;
import com.umg.banco.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    // Crear una cuenta
    @PostMapping
    public Cuenta crearCuenta(@RequestBody Cuenta cuenta) {
        return cuentaService.crear(cuenta);
    }

    // Listar todas las cuentas
    @GetMapping
    public List<Cuenta> listarCuentas() {
        return cuentaService.obtenerTodas(); // Nombre correcto del método
    }

    // Obtener cuenta por ID
    @GetMapping("/{id}")
    public Cuenta obtenerCuentaPorId(@PathVariable Long id) {
        return cuentaService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada con id " + id));
    }

    // Actualizar cuenta
    @PutMapping("/{id}")
    public Cuenta actualizarCuenta(@PathVariable Long id, @RequestBody Cuenta cuentaActualizada) {
        return cuentaService.actualizar(id, cuentaActualizada);
    }

    // Eliminar cuenta
    @DeleteMapping("/{id}")
    public void eliminarCuenta(@PathVariable Long id) {
        cuentaService.eliminar(id);
    }
}

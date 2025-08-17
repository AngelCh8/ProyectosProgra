package com.umg.banco.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.umg.banco.entity.Transaccion;
import com.umg.banco.repository.TransaccionRepository;

@Service
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;

    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    // Crear transacción
    public Transaccion crearTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    // Listar todas las transacciones
    public List<Transaccion> listarTransacciones() {
        return transaccionRepository.findAll();
    }

    // Obtener transacción por ID
    public Transaccion obtenerTransaccionPorId(Long id) {
        return transaccionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transacción no encontrada con id " + id));
    }

    // Actualizar transacción
    public Transaccion actualizarTransaccion(Long id, Transaccion transaccionActualizada) {
        return transaccionRepository.findById(id)
                .map(transaccion -> {
                    transaccion.setTipo(transaccionActualizada.getTipo());
                    transaccion.setMonto(transaccionActualizada.getMonto());
                    transaccion.setFecha(transaccionActualizada.getFecha());
                    transaccion.setCuenta(transaccionActualizada.getCuenta());
                    return transaccionRepository.save(transaccion);
                }).orElseThrow(() -> new RuntimeException("Transacción no encontrada con id " + id));
    }

    // Eliminar transacción
    public void eliminarTransaccion(Long id) {
        transaccionRepository.deleteById(id);
    }
}

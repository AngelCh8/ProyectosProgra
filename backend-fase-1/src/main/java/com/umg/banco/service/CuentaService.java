package com.umg.banco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umg.banco.entity.Cuenta;
import com.umg.banco.repository.CuentaRepository;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public List<Cuenta> obtenerTodas() {
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> obtenerPorId(Long id) {
        return cuentaRepository.findById(id);
    }

    public Cuenta crear(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Cuenta actualizar(Long id, Cuenta cuentaActualizada) {
        return cuentaRepository.findById(id)
                .map(cuenta -> {
                    cuenta.setTipo(cuentaActualizada.getTipo());
                    cuenta.setSaldo(cuentaActualizada.getSaldo());
                    cuenta.setCliente(cuentaActualizada.getCliente());
                    return cuentaRepository.save(cuenta);
                }).orElseThrow(() -> new RuntimeException("Cuenta no encontrada con id " + id));
    }

    public void eliminar(Long id) {
        cuentaRepository.deleteById(id);
    }
}

package com.umg.banco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umg.banco.entity.Cliente;
import com.umg.banco.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(Long id, Cliente clienteActualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNombre(clienteActualizado.getNombre());
                    cliente.setEmail(clienteActualizado.getEmail());
                    return clienteRepository.save(cliente);
                }).orElseThrow(() -> new RuntimeException("Cliente no encontrado con id " + id));
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
}
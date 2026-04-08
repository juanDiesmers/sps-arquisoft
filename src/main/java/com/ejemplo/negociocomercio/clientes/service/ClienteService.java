package com.arquisoft.negociocomercio.clientes.service;

import com.arquisoft.negociocomercio.clientes.entity.Cliente;
import com.arquisoft.negociocomercio.clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente guardar(Cliente cliente) {
        if (cliente.getFechaRegistro() == null) {
            cliente.setFechaRegistro(LocalDateTime.now());
        }
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(Long id, Cliente clienteActualizado) {
        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);

        if (clienteExistente == null) {
            return null;
        }

        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setCorreo(clienteActualizado.getCorreo());

        if (clienteActualizado.getFechaRegistro() != null) {
            clienteExistente.setFechaRegistro(clienteActualizado.getFechaRegistro());
        }

        return clienteRepository.save(clienteExistente);
    }

    public boolean eliminar(Long id) {
        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);

        if (clienteExistente == null) {
            return false;
        }

        clienteRepository.deleteById(id);
        return true;
    }
}
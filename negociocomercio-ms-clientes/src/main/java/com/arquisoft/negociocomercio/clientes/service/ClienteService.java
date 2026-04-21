package com.arquisoft.negociocomercio.clientes.service;

import com.arquisoft.negociocomercio.clientes.dto.ClienteMessage;
import com.arquisoft.negociocomercio.clientes.entity.Cliente;
import com.arquisoft.negociocomercio.clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void guardarDesdeEventos(List<ClienteMessage> mensajes) {
        for (ClienteMessage msg : mensajes) {
            guardarDesdeEvento(msg);
        }
    }

    @Transactional
    public Cliente guardarDesdeEvento(ClienteMessage msg) {
        Cliente cliente = clienteRepository.findByCorreo(msg.getCorreo()).orElseGet(Cliente::new);

        cliente.setNombre(msg.getNombre());
        cliente.setCorreo(msg.getCorreo());
        cliente.setFechaRegistro(
                msg.getFechaRegistro() != null ? msg.getFechaRegistro() : LocalDateTime.now()
        );

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
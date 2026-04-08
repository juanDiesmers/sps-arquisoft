package com.ejemplo.negociocomercio.service;

import com.ejemplo.negociocomercio.model.Cliente;
import com.ejemplo.negociocomercio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> buscarPorCorreo(String correo) {
        return Optional.ofNullable(clienteRepository.findByCorreo(correo));
    }
}
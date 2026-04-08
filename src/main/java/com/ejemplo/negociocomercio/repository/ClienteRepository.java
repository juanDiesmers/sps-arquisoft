package com.ejemplo.negociocomercio.repository;

import com.ejemplo.negociocomercio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCorreo(String correo);
}
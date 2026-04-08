package com.arquisoft.negociocomercio.clientes.repository;

import com.arquisoft.negociocomercio.clientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
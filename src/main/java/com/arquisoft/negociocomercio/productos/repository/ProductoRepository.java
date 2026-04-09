package com.arquisoft.negociocomercio.productos.repository;

import com.arquisoft.negociocomercio.productos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
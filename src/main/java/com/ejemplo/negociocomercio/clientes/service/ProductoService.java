package com.arquisoft.negociocomercio.productos.service;

import com.arquisoft.negociocomercio.productos.entity.Producto;
import com.arquisoft.negociocomercio.productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizar(Long id, Producto productoActualizado) {
        Producto productoExistente = productoRepository.findById(id).orElse(null);

        if (productoExistente == null) {
            return null;
        }

        productoExistente.setNombre(productoActualizado.getNombre());
        productoExistente.setPrecio(productoActualizado.getPrecio());
        productoExistente.setStock(productoActualizado.getStock());
        productoExistente.setActivo(productoActualizado.getActivo());

        return productoRepository.save(productoExistente);
    }

    public boolean eliminar(Long id) {
        Producto productoExistente = productoRepository.findById(id).orElse(null);

        if (productoExistente == null) {
            return false;
        }

        productoRepository.deleteById(id);
        return true;
    }
}
package com.ac.umg.microserv.service.impl;

import com.ac.umg.microserv.dto.ProductoDto;
import com.ac.umg.microserv.entity.Producto;
import com.ac.umg.microserv.repository.ProductoRepository;
import com.ac.umg.microserv.service.IProductoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductoServiceImpl implements IProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductoDto crearProducto(ProductoDto productoDto) {
        Producto producto = new Producto();
        producto.setNombre(productoDto.getNombre());
        producto.setCategoria(productoDto.getCategoria());
        Producto guardado = productoRepository.save(producto);
        return new ProductoDto(guardado.getId(), guardado.getNombre(), guardado.getCategoria());
    }

    @Override
    public List<ProductoDto> obtenerTodos() {
        return productoRepository.findAll()
                .stream()
                .map(p -> new ProductoDto(p.getId(), p.getNombre(), p.getCategoria()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductoDto> obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .map(p -> new ProductoDto(p.getId(), p.getNombre(), p.getCategoria()));
    }

    @Override
    public ProductoDto actualizarProducto(Long id, ProductoDto productoDto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setNombre(productoDto.getNombre());
        producto.setCategoria(productoDto.getCategoria());
        Producto actualizado = productoRepository.save(producto);
        return new ProductoDto(actualizado.getId(), actualizado.getNombre(), actualizado.getCategoria());
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<ProductoDto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(p -> new ProductoDto(p.getId(), p.getNombre(), p.getCategoria()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductoDto> buscarPorCategoria(String categoria) {
        return productoRepository.findByCategoriaContainingIgnoreCase(categoria)
                .stream()
                .map(p -> new ProductoDto(p.getId(), p.getNombre(), p.getCategoria()))
                .collect(Collectors.toList());
    }
}

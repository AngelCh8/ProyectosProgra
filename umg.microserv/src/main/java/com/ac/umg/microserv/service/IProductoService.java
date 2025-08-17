package com.ac.umg.microserv.service;

import com.ac.umg.microserv.dto.ProductoDto;
import java.util.List;
import java.util.Optional;

public interface IProductoService {
    ProductoDto crearProducto(ProductoDto productoDto);
    List<ProductoDto> obtenerTodos();
    Optional<ProductoDto> obtenerPorId(Long id);
    ProductoDto actualizarProducto(Long id, ProductoDto productoDto);
    void eliminarProducto(Long id);
    List<ProductoDto> buscarPorNombre(String nombre);
    List<ProductoDto> buscarPorCategoria(String categoria);
}

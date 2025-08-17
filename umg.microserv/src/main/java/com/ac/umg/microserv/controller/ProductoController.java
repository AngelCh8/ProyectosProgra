package com.ac.umg.microserv.controller;

import com.ac.umg.microserv.dto.ProductoDto;
import com.ac.umg.microserv.service.IProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<ProductoDto> crearProducto(@Valid @RequestBody ProductoDto productoDto) {
        return ResponseEntity.ok(productoService.crearProducto(productoDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductoDto>> listarProductos() {
        return ResponseEntity.ok(productoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> actualizarProducto(@PathVariable Long id,
                                                          @Valid @RequestBody ProductoDto productoDto) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, productoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ProductoDto>> buscarPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(productoService.buscarPorNombre(nombre));
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProductoDto>> buscarPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(productoService.buscarPorCategoria(categoria));
    }
}


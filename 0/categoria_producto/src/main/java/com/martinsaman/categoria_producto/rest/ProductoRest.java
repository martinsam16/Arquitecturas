package com.martinsaman.categoria_producto.rest;

import com.martinsaman.categoria_producto.model.Producto;
import com.martinsaman.categoria_producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/producto")
public class ProductoRest {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> findAll(){
        return productoService.findAll();
    }

    @PostMapping
    public ResponseEntity<Producto> save(
            @RequestBody Producto producto
    ){
        return productoService.save(producto);
    }

    @PutMapping
    public ResponseEntity<Producto> update(
            @RequestBody Producto producto
    ){
        return productoService.update(producto);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(
            @RequestBody Producto producto
    ){
        return productoService.delete(producto);
    }
}

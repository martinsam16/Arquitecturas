package com.martinsaman.kafka_listener.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "categoria_producto", fallback = CategoriaProductoFallback.class)
public interface ICategoriaProducto {

    final String CATEGORIA = "/categoria";
    final String PRODUCTO = "/producto";


    @PostMapping(CATEGORIA)
    ResponseEntity<Object> saveCategoria(
            @RequestBody Object categoria
    );

    @PutMapping(CATEGORIA)
    ResponseEntity<Object> updateCategoria(
            @RequestBody Object categoria
    );

    @DeleteMapping(CATEGORIA)
    ResponseEntity<Void> deleteCategoria(
            @RequestBody Object categoria
    );

    //

    @PostMapping(PRODUCTO)
    ResponseEntity<Object> saveProducto(
            @RequestBody Object producto
    );

    @PutMapping(PRODUCTO)
    ResponseEntity<Object> updateProducto(
            @RequestBody Object producto
    );

    @DeleteMapping(PRODUCTO)
    ResponseEntity<Void> deleteProducto(
            @RequestBody Object producto
    );
}

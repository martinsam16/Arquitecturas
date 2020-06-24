package com.martinsaman.kafka_listener.clients;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoriaProductoFallback implements ICategoriaProducto {


    @Override
    public ResponseEntity<Object> saveCategoria(Object categoria) {
        return new ResponseEntity<>("El servicio cayo :c", HttpStatus.REQUEST_TIMEOUT);
    }

    @Override
    public ResponseEntity<Object> updateCategoria(Object categoria) {
        return new ResponseEntity<>("El servicio cayo :c", HttpStatus.REQUEST_TIMEOUT);
    }

    @Override
    public ResponseEntity<Void> deleteCategoria(Object categoria) {
        return new ResponseEntity<>(HttpStatus.REQUEST_TIMEOUT);
    }

    @Override
    public ResponseEntity<Object> saveProducto(Object producto) {
        return new ResponseEntity<>("El servicio cayo :c", HttpStatus.REQUEST_TIMEOUT);
    }

    @Override
    public ResponseEntity<Object> updateProducto(Object producto) {
        return new ResponseEntity<>("El servicio cayo :c", HttpStatus.REQUEST_TIMEOUT);
    }

    @Override
    public ResponseEntity<Void> deleteProducto(Object producto) {
        return new ResponseEntity<>(HttpStatus.REQUEST_TIMEOUT);
    }
}

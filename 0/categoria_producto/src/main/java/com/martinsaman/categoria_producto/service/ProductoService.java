package com.martinsaman.categoria_producto.service;

import com.martinsaman.categoria_producto.model.Categoria;
import com.martinsaman.categoria_producto.model.Producto;
import com.martinsaman.categoria_producto.repository.ICategoria;
import com.martinsaman.categoria_producto.repository.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private IProducto productoRepo;

    @Autowired
    private ICategoria categoriaRepo;

    public ResponseEntity<List<Producto>> findAll(){
        return new ResponseEntity<>(productoRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Producto> save(
            Producto producto
    ){
        Optional<Categoria> categoriaOptional = categoriaRepo.findById(producto.getCategoria().getId());
        if (categoriaOptional.isPresent()){
            producto.setCategoria(categoriaOptional.get());
            return new ResponseEntity<>(productoRepo.save(producto),HttpStatus.CREATED);
        }

        System.out.println("La categoria no existe D:");
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }

    public ResponseEntity<Producto> update(
            Producto producto
    ){
        Optional<Producto> optionalProducto = productoRepo.findById(producto.getId());

        if(optionalProducto.isPresent()){
            return save(producto);
        }
        System.out.println("Lo que quieres modificar no existe D:");
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> delete(
            Producto producto
    ){
        productoRepo.delete(producto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

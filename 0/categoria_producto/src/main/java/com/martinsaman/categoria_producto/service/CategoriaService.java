package com.martinsaman.categoria_producto.service;

import com.martinsaman.categoria_producto.model.Categoria;
import com.martinsaman.categoria_producto.repository.ICategoria;
import com.martinsaman.categoria_producto.repository.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private ICategoria categoriaRepo;

    @Autowired
    private IProducto productoRepo;

    public ResponseEntity<List<Categoria>> findAll(){
        return new ResponseEntity<>(categoriaRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Categoria> save(
            Categoria categoria
    ){
        return new ResponseEntity<>(categoriaRepo.save(categoria),HttpStatus.CREATED);
    }

    public ResponseEntity<Categoria> update(
            Categoria categoria
    ){
        Optional<Categoria> categoriaOptional = categoriaRepo.findById(categoria.getId());
        if (categoriaOptional.isPresent()){
            productoRepo.findAllByCategoria_Id(categoria.getId())
            .forEach((p)->{
                p.setCategoria(categoria);
                productoRepo.save(p);
            });
            return new ResponseEntity<>(categoriaRepo.save(categoria),HttpStatus.CREATED);
        }

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> delete(
            Categoria categoria
    ){
        categoriaRepo.delete(categoria);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}

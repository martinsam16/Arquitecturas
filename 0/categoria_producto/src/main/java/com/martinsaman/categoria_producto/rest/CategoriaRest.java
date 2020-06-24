package com.martinsaman.categoria_producto.rest;

import com.martinsaman.categoria_producto.model.Categoria;
import com.martinsaman.categoria_producto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/categoria")
public class CategoriaRest {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        return categoriaService.findAll();
    }

    @PostMapping
    public ResponseEntity<Categoria> save(
            @RequestBody Categoria categoria
    ){
        return categoriaService.save(categoria);
    }

    @PutMapping
    public ResponseEntity<Categoria> update(
            @RequestBody Categoria categoria
    ){
        return categoriaService.update(categoria);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(
            @RequestBody Categoria categoria
    ){
        return categoriaService.delete(categoria);
    }
}

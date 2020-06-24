package com.example.categoria.rest;

import com.example.categoria.model.Categoria;
import com.example.categoria.repository.ICategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin({ "*" })
@RestController
@RequestMapping("/api/categoria")
public class CategoriaRest {

    @Autowired
    private ICategoria repo;

    @Autowired
    private Environment environment;

    @GetMapping
    public List<Categoria> listCategoria() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/{id}")
    public Categoria obtenerCategoria(@PathVariable("id") Long id) {
        System.out.println("[INFO] Enviando desde el puerto: " + environment.getProperty("local.server.port"));
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public void registrarCategoria(@RequestBody Categoria c) {
        try {
            repo.saveAndFlush(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping
    public void actualizarCategoria(@RequestBody Categoria c) {
        try {
            repo.saveAndFlush(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable("id") Long id) {
        try {
            repo.eliminarCategoria(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

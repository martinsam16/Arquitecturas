package com.openinnovations.ProductoService.rest;

import java.util.List;
import java.util.Optional;

import com.openinnovations.ProductoService.clients.ICategoriaClient;
import com.openinnovations.ProductoService.model.Producto;
import com.openinnovations.ProductoService.repository.IProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin({"*"})
@RestController
@RequestMapping("/api/producto")
public class ProductoRest {

    @Autowired
    private IProducto repo;

    @Autowired
    private ICategoriaClient categoriaClient;

    @GetMapping
    public List<Producto> listarProductos() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable("id") Long id) {
        Optional<Producto> opcional = repo.findById(id);

        if (opcional.isPresent()) {

            Producto producto = opcional.get();

            producto.setCategoria(categoriaClient.obtenerCategoria(producto.getIDCAT()));

            return producto;
        } else {
            return null;

        }
    }

    @PostMapping
    public void registrarProducto(@RequestBody Producto p) {
        try {
            p.setearIdCategoria();
            repo.saveAndFlush(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PutMapping
    public void actualizarProducto(@RequestBody Producto p) {
        try {
            p.setearIdCategoria();
            repo.saveAndFlush(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping(value = "/{id}")
    public void eliminarProducto(@PathVariable("id") Long id) {
        try {
            repo.eliminarProducto(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
package com.openinnovations.ProductoService.clients;

import java.util.List;

import com.openinnovations.ProductoService.fallbacks.CategoriaFallback;
import com.openinnovations.ProductoService.model.Categoria;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Es el spring.application.name del servicio con el que me comunico :,v
@FeignClient(name = "categoria", fallback = CategoriaFallback.class)
@RibbonClient(name = "categoria")
public interface ICategoriaClient{

    @GetMapping("/api/categoria")
    public List<Categoria> findAll();

    @GetMapping("/api/categoria/{id}")
    public Categoria obtenerCategoria(@PathVariable(name = "id") Long id);
}
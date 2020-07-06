package com.martinsaman.apigateway.clients.curso_service.curso;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "35.194.18.10:3007/curso", name = "a")
//@FeignClient(url = "localhost:3007/curso", name = "a")
public interface CursoClient {

    @GetMapping
    List<Curso> listar();

    @PostMapping
    Curso guardar(@RequestBody CursoDto cursoDto);

    @DeleteMapping
    void eliminar(@RequestParam("id") String id);

    @GetMapping("/uno")
    Curso buscarPorId(@RequestParam("id") String id);
}

package com.martinsaman.apigateway.clients.curso_service.usuario_curso;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(url = "23.102.156.137:3007/usuario_curso", name = "b")
//@FeignClient(url = "localhost:3007/usuario_curso", name = "b")
public interface UsuarioCursoClient {

    @GetMapping
    List<UsuarioCurso> listar();

    @PostMapping
    UsuarioCurso guardarActualizar(@RequestBody UsuarioCurso usuarioCurso);
}

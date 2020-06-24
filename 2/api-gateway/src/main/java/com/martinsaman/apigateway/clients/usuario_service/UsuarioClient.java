package com.martinsaman.apigateway.clients.usuario_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "23.102.156.137:3005/usuario", name = "d")
//@FeignClient(url = "localhost:3005/usuario", name = "d")
public interface UsuarioClient {

    @GetMapping
    List<Usuario> listar();

    @PostMapping
    Usuario guardarUsuario(@RequestBody UsuarioDto dto);

    @GetMapping("/id")
    Usuario obtenerUsuarioId(@RequestParam("id") String id);

    @PostMapping("/req")
    Usuario requestUser(@RequestParam("email") String email);

    @DeleteMapping
    void eliminarUsuario(@RequestParam("email") String email);

}

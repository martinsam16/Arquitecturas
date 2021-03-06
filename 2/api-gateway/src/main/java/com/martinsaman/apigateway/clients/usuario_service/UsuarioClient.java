package com.martinsaman.apigateway.clients.usuario_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "35.194.18.10:3005/usuario", name = "c")
//@FeignClient(url = "localhost:3005/usuario", name = "c")
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

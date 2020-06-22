package com.martinsaman.userservice.usuario.rest;

import com.martinsaman.userservice.usuario.model.Usuario;
import com.martinsaman.userservice.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController("/usuario")
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public Usuario getUser(@RequestParam("email") String email) {
        return usuarioService.getUser(email);
    }

    @PostMapping
    public Usuario requestUser(@RequestParam("email") String email) {
        return usuarioService.requestUser(email);
    }

    @DeleteMapping
    public void eliminarUsuario(@RequestParam("email") String email) {
        usuarioService.eliminarUsuario(email);
    }

}

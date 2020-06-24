package com.martinsaman.userservice.usuario.rest;

import com.martinsaman.userservice.usuario.dto.UsuarioDto;
import com.martinsaman.userservice.usuario.model.Usuario;
import com.martinsaman.userservice.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @PostMapping
    public Usuario guardarUsuario(@RequestBody UsuarioDto dto) {
        return usuarioService.guardar(dto);
    }

    @GetMapping("/id")
    public Usuario obtenerUsuarioId(@RequestParam("id") String id) {
        return usuarioService.obtenerUsuarioId(id);
    }

    @PostMapping("/req")
    public Usuario requestUser(@RequestParam("email") String email) {
        return usuarioService.requestUser(email);
    }

    @DeleteMapping
    public void eliminarUsuario(@RequestParam("email") String email) {
        usuarioService.eliminarUsuario(email);
    }

}

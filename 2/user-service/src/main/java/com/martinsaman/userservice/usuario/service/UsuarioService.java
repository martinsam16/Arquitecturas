package com.martinsaman.userservice.usuario.service;

import com.martinsaman.userservice.usuario.model.Usuario;
import com.martinsaman.userservice.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUser(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    public Usuario requestUser(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseGet(() -> usuarioRepository.save(new Usuario(email)));
    }

    public void eliminarUsuario(String email) {
        usuarioRepository.deleteByEmail(email);
    }
}

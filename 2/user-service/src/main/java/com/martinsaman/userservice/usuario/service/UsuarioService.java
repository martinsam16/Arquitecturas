package com.martinsaman.userservice.usuario.service;

import com.martinsaman.userservice.usuario.dto.UsuarioDto;
import com.martinsaman.userservice.usuario.model.Usuario;
import com.martinsaman.userservice.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario guardar(UsuarioDto dto) {
        return usuarioRepository.save(
                usuarioRepository.findByEmail(dto.getEmail())
                        .map(usuario -> {
                            usuario.setName(dto.getName());
                            usuario.setBirthDay(dto.getBirthDay());
                            return usuario;
                        })
                        .orElseGet(() -> new Usuario(dto))
        );
    }

    public Usuario obtenerUsuarioId(String id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario requestUser(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseGet(() -> usuarioRepository.save(new Usuario(email)));
    }

    public void eliminarUsuario(String email) {
        usuarioRepository.deleteByEmail(email);
    }
}

package com.martinsaman.courseservice.usuario_curso.service;

import com.martinsaman.courseservice.usuario_curso.repository.UsuarioCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;

}

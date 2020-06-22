package com.martinsaman.courseservice.usuario_curso.rest;

import com.martinsaman.courseservice.usuario_curso.model.UsuarioCurso;
import com.martinsaman.courseservice.usuario_curso.service.UsuarioCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuario_curso")
public class UsuarioCursoRest {

    @Autowired
    private UsuarioCursoService usuarioCursoService;

    @GetMapping
    public List<UsuarioCurso> listar(){
        return usuarioCursoService.listar();
    }

    @PostMapping
    public UsuarioCurso guardarActualizar(@RequestBody UsuarioCurso usuarioCurso) {
        return usuarioCursoService.guardarActualizar(usuarioCurso);
    }

}

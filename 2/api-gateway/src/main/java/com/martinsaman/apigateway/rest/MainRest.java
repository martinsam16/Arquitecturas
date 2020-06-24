package com.martinsaman.apigateway.rest;

import com.martinsaman.apigateway.clients.curso_service.curso.Curso;
import com.martinsaman.apigateway.clients.curso_service.curso.CursoDto;
import com.martinsaman.apigateway.clients.curso_service.usuario_curso.UsuarioCurso;
import com.martinsaman.apigateway.clients.curso_service.usuario_curso.UsuarioCursoDto;
import com.martinsaman.apigateway.clients.usuario_service.Usuario;
import com.martinsaman.apigateway.clients.usuario_service.UsuarioDto;
import com.martinsaman.apigateway.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class MainRest {

    @Autowired
    private MainService mainService;

    @GetMapping("/curso")
    public List<Curso> listarCursos() {
        return mainService.listarCursos();
    }

    @PostMapping("/curso")
    public Curso guardarCurso(@RequestBody CursoDto cursoDto) {
        return mainService.guardarCurso(cursoDto);
    }

    @PostMapping("/curso/comprar")
    public void comprarCurso(@RequestBody CompraDto compraDto) {
        mainService.comprarCurso(compraDto.getEmail(), compraDto.getCursosComprar());
    }

    @GetMapping("/usuario")
    public List<Usuario> listarUsuarios() {
        return mainService.listarUsuarios();
    }

    @GetMapping("/usuario_curso")
    public List<UsuarioCursoDto> listarUsuarioCurso() {
        return mainService.listarUsuarioCurso();
    }

    @PostMapping("/usuario")
    public Usuario guardarUsuario(@RequestBody UsuarioDto dto) {
        return mainService.guardarUsuario(dto);
    }
}

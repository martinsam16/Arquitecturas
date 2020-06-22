package com.martinsaman.courseservice.curso.rest;

import com.martinsaman.courseservice.curso.dto.CursoDto;
import com.martinsaman.courseservice.curso.model.Curso;
import com.martinsaman.courseservice.curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/curso")
public class CursoRest {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listar(){
        return cursoService.listarCursos();
    }

    @PostMapping
    public Curso guardar(@RequestBody CursoDto cursoDto) {
        return cursoService.guardarCurso(cursoDto);
    }

    @DeleteMapping
    public void eliminar(@RequestParam("id") String id) {
        cursoService.eliminar(id);
    }

}

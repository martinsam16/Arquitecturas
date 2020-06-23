package com.martinsaman.courseservice.curso.service;

import com.martinsaman.courseservice.curso.dto.CursoDto;
import com.martinsaman.courseservice.curso.model.Curso;
import com.martinsaman.courseservice.curso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso guardarCurso(CursoDto cursoDto) {
        return cursoRepository.save(
                cursoRepository.findByName(cursoDto.getName())
                .map(curso->{
                    curso.setDescription(cursoDto.getDescription());
                    curso.setImage(cursoDto.getImage());
                    curso.setPrice(cursoDto.getPrice());
                    curso.setAuthor(cursoDto.getAuthor());
                    return curso;
                }).orElse(new Curso(cursoDto))
        );
    }

    public List<Curso> listarCursos(){
        return cursoRepository.findAll();
    }

    public void eliminar(String id) {
        cursoRepository.deleteById(id);
    }

}

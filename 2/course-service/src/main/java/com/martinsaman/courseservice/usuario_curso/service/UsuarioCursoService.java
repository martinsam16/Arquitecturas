package com.martinsaman.courseservice.usuario_curso.service;

import com.martinsaman.courseservice.curso.model.Curso;
import com.martinsaman.courseservice.usuario_curso.model.UsuarioCurso;
import com.martinsaman.courseservice.usuario_curso.repository.UsuarioCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UsuarioCursoService {

    @Autowired
    private UsuarioCursoRepository usuarioCursoRepository;

    public List<UsuarioCurso> listar(){
        return usuarioCursoRepository.findAll();
    }

    public UsuarioCurso guardarActualizar(UsuarioCurso usuarioCurso) {
        Optional<UsuarioCurso> encontradoOpt = usuarioCursoRepository.findById(usuarioCurso.get_id());
        if (encontradoOpt.isPresent()) {
            UsuarioCurso encontrado = encontradoOpt.get();
            List<Curso> listaCursos = Stream
                    .concat(encontrado.getCursos().stream(),
                            usuarioCurso.getCursos().stream())
                    .collect(Collectors.toList());
            encontrado.setCursos(listaCursos);
            return usuarioCursoRepository.save(encontrado);
        } else {
            return usuarioCursoRepository.save(usuarioCurso);
        }
    }

}

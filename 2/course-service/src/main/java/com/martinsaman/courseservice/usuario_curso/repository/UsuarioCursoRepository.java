package com.martinsaman.courseservice.usuario_curso.repository;

import com.martinsaman.courseservice.usuario_curso.model.UsuarioCurso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioCursoRepository extends MongoRepository<UsuarioCurso, String> {


}

package com.martinsaman.courseservice.curso.repository;

import com.martinsaman.courseservice.curso.model.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends MongoRepository<Curso, String> {
    Optional<Curso> findByName(String name);
}

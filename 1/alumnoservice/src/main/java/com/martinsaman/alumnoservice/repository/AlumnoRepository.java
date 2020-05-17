package com.martinsaman.alumnoservice.repository;

import com.martinsaman.alumnoservice.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    List<Alumno> findAllByESTALUM(String ESTALUM);
}

package com.martinsaman.alumnoservice.repository;

import com.martinsaman.alumnoservice.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    List<Persona> findAllByESTPER(String ESTPER);

    // Innecesario en relacional :p
//    Optional<Persona> findPersonaByIDPER(Integer IDPER);
}

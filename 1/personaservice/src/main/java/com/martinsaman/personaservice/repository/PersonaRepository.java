package com.martinsaman.personaservice.repository;

import com.martinsaman.personaservice.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, String> {

    Optional<Persona> findPersonaByIDPER(Integer IDPER);

    List<Persona> findAllByESTPER(String ESTPER);
}

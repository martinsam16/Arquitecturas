package com.martinsaman.alumnoservice.service;

import com.martinsaman.alumnoservice.model.Persona;
import com.martinsaman.alumnoservice.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> listar() {
        return personaRepository.findAllByESTPER("A");
    }

    public void crearPersona(Persona persona) {
        // Para evitar que se edite si ya existe
        if (!personaRepository.findById(persona.getIDPER()).isPresent()) {
            personaRepository.save(persona);
        }
    }

    public void modificarPersona(Persona persona) {
        personaRepository.findById(persona.getIDPER())
                .ifPresent(personaRepository::save);
    }

    public void eliminarPersona(Integer IDPER) {
        personaRepository.findById(IDPER)
                .ifPresent((p) -> {
                    p.setESTPER("I");
                    personaRepository.save(p);
                });
    }
}

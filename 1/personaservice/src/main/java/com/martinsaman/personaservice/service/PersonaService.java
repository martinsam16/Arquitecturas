package com.martinsaman.personaservice.service;

import com.martinsaman.personaservice.events.DatabaseDto;
import com.martinsaman.personaservice.model.Persona;
import com.martinsaman.personaservice.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public void personaDatabaseAction(DatabaseDto dto) {
        switch (dto.getDatabaseEvent()) {
            case CREAR:
                crearPersona((Persona) dto.getModel());
                break;
            case MODIFICAR:
                modificarPersona((Persona) dto.getModel());
                break;
            case ELIMINAR:
                eliminarPersona((Integer) dto.getIdModel());
                break;
            default:
                break;
        }
    }

    public void crearPersona(Persona persona) {
        personaRepository.save(persona);
    }

    public void modificarPersona(Persona persona) {
        personaRepository.findPersonaByIDPER(persona.getIDPER())
                .ifPresent(personaRepository::save);
    }

    public void eliminarPersona(Integer IDPER) {
        personaRepository.findPersonaByIDPER(IDPER)
                .ifPresent((p) -> {
                    p.setESTPER("I");
                    crearPersona(p);
                });
    }

    public List<Persona> listarPersona() {
        return new ArrayList<>(personaRepository.findAllByESTPER("A"));
    }

}

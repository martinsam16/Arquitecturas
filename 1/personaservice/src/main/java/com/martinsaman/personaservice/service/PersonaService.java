package com.martinsaman.personaservice.service;

import com.martinsaman.personaservice.events.database.DatabaseDto;
import com.martinsaman.personaservice.events.database.DatabaseEvent;
import com.martinsaman.personaservice.events.database.DatabaseModel;
import com.martinsaman.personaservice.events.database.DatabaseProducer;
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
    @Autowired
    private DatabaseProducer databaseProducer;

    private void enviarEvento(DatabaseEvent event, Persona persona, Integer idEliminar) {
        switch (event) {
            case CREAR:
            case MODIFICAR:
                databaseProducer.enviarEvento(
                        new DatabaseDto(event,
                                personaRepository.save(persona),
                                null,
                                DatabaseModel.PERSONA
                        ));
                break;
            case ELIMINAR:
                databaseProducer.enviarEvento(
                        new DatabaseDto(
                                DatabaseEvent.ELIMINAR,
                                null,
                                idEliminar,
                                DatabaseModel.PERSONA
                        )
                );
                break;
        }
    }

    /**
     * Si fuese Listener se agregaría un modo en los métodos: para evitar el circulo vicioso :D
     * En este caso esta en modo Producer por lo que no es necesario xd
     */

    public void crearPersona(Persona persona) {
        enviarEvento(DatabaseEvent.CREAR, persona, null);
    }

    public void modificarPersona(Persona persona) {
        personaRepository.findPersonaByIDPER(persona.getIDPER())
                .ifPresent((p) -> {
                    enviarEvento(DatabaseEvent.MODIFICAR, p, null);
                });
    }

    public void eliminarPersona(Integer IDPER) {
        personaRepository.findPersonaByIDPER(IDPER)
                .ifPresent((p) -> {
                    p.setESTPER("I");
                    personaRepository.save(p);  //Se actualiza el de este microservicio
                    enviarEvento(DatabaseEvent.ELIMINAR, null, IDPER);
                });
    }

    @Deprecated
    public void pruebas() {
        Persona p = new Persona(
                2,
                "Nataly",
                "LOPEZ",
                "ISAGUIRRE",
                "72720459",
                "A");
        crearPersona(p);
        modificarPersona(p);
        eliminarPersona(p.getIDPER());
    }

    public List<Persona> listarPersona() {
        return new ArrayList<>(personaRepository.findAllByESTPER("A"));
    }

}

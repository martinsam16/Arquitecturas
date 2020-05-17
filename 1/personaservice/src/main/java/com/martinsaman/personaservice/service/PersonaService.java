package com.martinsaman.personaservice.service;

import com.martinsaman.personaservice.events.database.DatabaseDto;
import com.martinsaman.personaservice.events.database.DatabaseEvent;
import com.martinsaman.personaservice.events.database.DatabaseModel;
import com.martinsaman.personaservice.events.database.DatabaseProducer;
import com.martinsaman.personaservice.model.Persona;
import com.martinsaman.personaservice.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                                persona,
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


    public void crearPersona(Persona persona) {
        if (!personaRepository.findPersonaByIDPER(persona.getIDPER())
                .isPresent()) {
            enviarEvento(DatabaseEvent.CREAR, personaRepository.save(persona), null);
        }
    }

    public void modificarPersona(Persona persona) {
        personaRepository.findPersonaByIDPER(persona.getIDPER())
                .ifPresent((p) -> {
                    persona.setId(p.getId()); // para que modifique y no registre otro xd
                    enviarEvento(DatabaseEvent.MODIFICAR, personaRepository.save(persona), null);
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
    public void crear() {
        Persona p = new Persona(
                2,
                "Nataly",
                "LOPEZ",
                "ISAGUIRRE",
                "72720459",
                "A");
        crearPersona(p);
//        modificarPersona(p);
//        eliminarPersona(p.getIDPER());
    }

    @Deprecated
    public void modificar() {
        Persona p = new Persona(
                2,
                "FFFFFFF",
                "FFFFFFFF",
                "FFFFFFF",
                "72720459",
                "A");
        modificarPersona(p);
//        eliminarPersona(p.getIDPER());
    }

    public List<Persona> listarPersona() {
        return personaRepository.findAllByESTPER("A");
    }

}

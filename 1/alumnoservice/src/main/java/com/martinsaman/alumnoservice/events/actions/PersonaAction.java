package com.martinsaman.alumnoservice.events.actions;

import com.google.gson.Gson;
import com.martinsaman.alumnoservice.events.database.DatabaseDto;
import com.martinsaman.alumnoservice.model.Persona;
import com.martinsaman.alumnoservice.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaAction {

    @Autowired
    private PersonaService personaService;

    public void accion(DatabaseDto dto) {

        /*
         * El object es reconocido como: com.google.gson.internal.LinkedTreeMap
         * por eso se hace lo siguiente :D
         */
        Gson gson = new Gson();
        Persona p = gson.fromJson(gson.toJson(dto.getModel()), Persona.class);

        switch (dto.getDatabaseEvent()) {
            case CREAR:
                personaService.crearPersona(p);
                break;
            case MODIFICAR:
                personaService.modificarPersona(p);
                break;
            case ELIMINAR:
                personaService.eliminarPersona(gson.fromJson(gson.toJson(dto.getIdModel()), Integer.class));
                break;
            default:
                System.out.println("ALGO ANDA MAL");
                break;
        }
    }
}

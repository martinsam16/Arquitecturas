package com.martinsaman.personaservice.rest;

import com.martinsaman.personaservice.model.Persona;
import com.martinsaman.personaservice.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/persona")
public class PersonaRest {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> listar() {
        return personaService.listarPersona();
    }

    @GetMapping("/crear")
    public void crear(){
        personaService.crear();
    }

    @GetMapping("/modificar")
    public void modificar(){
        personaService.modificar();
    }

    @PostMapping
    public void crear(@RequestBody Persona persona) {
        personaService.crearPersona(persona);
    }

    @PutMapping
    public void modificar(@RequestBody Persona persona) {
        personaService.modificarPersona(persona);
    }

    @DeleteMapping
    public void eliminar(@RequestParam("IDPER") Integer IDPER) {
        personaService.eliminarPersona(IDPER);
    }


}

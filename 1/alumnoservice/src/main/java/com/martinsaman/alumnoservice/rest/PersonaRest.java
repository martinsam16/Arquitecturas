package com.martinsaman.alumnoservice.rest;

import com.martinsaman.alumnoservice.model.Persona;
import com.martinsaman.alumnoservice.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * No tiene sentido hacer estas operaciones en este microservicio
 * ya que para eso está el otro :D
 */

@RestController
@RequestMapping("/persona")
@CrossOrigin
public class PersonaRest {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> listar(){
        return personaService.listar();
    }
}

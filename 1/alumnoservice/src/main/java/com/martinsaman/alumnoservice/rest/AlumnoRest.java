package com.martinsaman.alumnoservice.rest;

import com.martinsaman.alumnoservice.dto.AlumnoDto;
import com.martinsaman.alumnoservice.model.Alumno;
import com.martinsaman.alumnoservice.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
@CrossOrigin
public class AlumnoRest {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/crear")
    public void crear(){
        alumnoService.crearAlumno();
    }

    @GetMapping
    public List<Alumno> listar(){
        return alumnoService.listar();
    }

    @PostMapping
    public void registrar(@RequestBody AlumnoDto alumnoDto){
        alumnoService.crearAlumno(alumnoDto);
    }

    @PutMapping
    public void actualizar(@RequestBody AlumnoDto alumnoDto){
        alumnoService.modificarAlumno(alumnoDto);
    }

    @DeleteMapping
    public void eliminar(@RequestParam("IDALUM") Integer IDALUMN){
        alumnoService.eliminarAlumno(IDALUMN);
    }
}

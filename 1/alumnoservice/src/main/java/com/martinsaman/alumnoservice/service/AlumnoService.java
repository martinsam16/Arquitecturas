package com.martinsaman.alumnoservice.service;

import com.martinsaman.alumnoservice.dto.AlumnoDto;
import com.martinsaman.alumnoservice.model.Alumno;
import com.martinsaman.alumnoservice.repository.AlumnoRepository;
import com.martinsaman.alumnoservice.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private PersonaRepository personaRepository;

    public void crearAlumno(AlumnoDto alumnoDto) {
        personaRepository.findById(alumnoDto.getIDPER())
                .ifPresent((p) -> {
                    if (!alumnoRepository.findById(alumnoDto.getIDALUM()).isPresent()) {
                        Alumno alumno = new Alumno();
                        alumno.setIDALUM(alumnoDto.getIDALUM());
                        alumno.setFECMAT(alumnoDto.getFECMAT());
                        alumno.setESTALUM("A");
                        alumno.setPersona(p);

                        alumnoRepository.save(alumno);
                    }
                });
    }

    public void modificarAlumno(AlumnoDto alumnoDto) {
        personaRepository.findById(alumnoDto.getIDPER()).flatMap(p -> alumnoRepository.findById(alumnoDto.getIDALUM())).ifPresent((a) -> {
            a.setFECMAT(alumnoDto.getFECMAT());
            alumnoRepository.save(a);
        });
    }

    public void eliminarAlumno(Integer IDALUM) {
        alumnoRepository.findById(IDALUM)
                .ifPresent((a) -> {
                    a.setESTALUM("I");
                    alumnoRepository.save(a);
                });
    }

    public List<Alumno> listar() {
        return alumnoRepository.findAllByESTALUM("A");
    }

    @Deprecated
    public void crearAlumno(){
        AlumnoDto alumnoDto = new AlumnoDto();
        alumnoDto.setIDALUM(1);
        alumnoDto.setFECMAT(new Date());
        alumnoDto.setIDPER(2);
        crearAlumno(alumnoDto);
    }
}

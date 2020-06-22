package com.martinsaman.courseservice;

import com.martinsaman.courseservice.curso.model.Curso;
import com.martinsaman.courseservice.curso.repository.CursoRepository;
import com.martinsaman.courseservice.usuario_curso.model.UsuarioCurso;
import com.martinsaman.courseservice.usuario_curso.repository.UsuarioCursoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class CourseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner preloadData(CursoRepository cursoRepo, UsuarioCursoRepository usuarioRepo) {
        return args -> {
            cursoRepo.deleteAll();
            usuarioRepo.deleteAll();

            cursoRepo.save(new Curso("author", "name", "image", "description"));
            usuarioRepo.save(new UsuarioCurso("ms_correo", cursoRepo.findAll()));

        };
    }
}

package com.martinsaman.userservice;

import com.martinsaman.userservice.usuario.model.Usuario;
import com.martinsaman.userservice.usuario.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.util.Date;

@SpringBootApplication
@EnableMongoAuditing
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner preloadData(UsuarioRepository usuarioRepository) {
        return args -> {
            usuarioRepository.deleteAll();
            usuarioRepository.save(new Usuario("martin.saman@vallegrande.edu.pe", "Martín Alexis Samán Arata", new Date()));
        };
    }
}

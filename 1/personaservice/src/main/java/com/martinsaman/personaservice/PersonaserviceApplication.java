package com.martinsaman.personaservice;

import com.martinsaman.personaservice.model.Persona;
import com.martinsaman.personaservice.repository.PersonaRepository;
import com.martinsaman.personaservice.service.PersonaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class PersonaserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonaserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner preloadData(PersonaRepository repository) {
        return args -> {
            repository.deleteAll();
            repository.save(new Persona(
                    1,
                    "Martin",
                    "SAMAN",
                    "ARATA",
                    "72720455",
                    "A"));
        };
    }
}

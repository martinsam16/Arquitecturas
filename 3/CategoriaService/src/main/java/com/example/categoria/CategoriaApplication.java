package com.example.categoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CategoriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoriaApplication.class, args);
    }

    

}

package com.martinsaman.alumnoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AlumnoserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlumnoserviceApplication.class, args);
    }

}

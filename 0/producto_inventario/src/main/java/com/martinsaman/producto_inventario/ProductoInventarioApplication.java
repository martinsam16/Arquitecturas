package com.martinsaman.producto_inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductoInventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductoInventarioApplication.class, args);
    }

}

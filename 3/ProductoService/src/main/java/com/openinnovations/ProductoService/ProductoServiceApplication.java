package com.openinnovations.ProductoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients
//@EnableCircuitBreaker
//@EnableHystrix
@EnableDiscoveryClient
public class ProductoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductoServiceApplication.class, args);
    }

}

package com.martinsaman.kafka_listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class KafkaListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaListenerApplication.class, args);
    }

}

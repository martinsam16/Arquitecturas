package com.martinsaman.kafka_producer;

import com.martinsaman.kafka_producer.dto.DataDto;
import com.martinsaman.kafka_producer.service.ProducerService;
import com.martinsaman.kafka_producer.type.CollectionDatabase;
import com.martinsaman.kafka_producer.type.DatabaseAction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class KafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Bean
    CommandLineRunner preloadData(ProducerService producerService){
        return args -> {
            producerService.enviar(
                    DataDto.builder()
                            .action(DatabaseAction.SAVE)
                            .collectionDatabase(CollectionDatabase.CATEGORIA)
                            .data("xxx")
                            .build()
            );
        };
    }
}

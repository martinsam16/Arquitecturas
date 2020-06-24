package com.martinsaman.kafka_producer.rest;

import com.martinsaman.kafka_producer.dto.DataDto;
import com.martinsaman.kafka_producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProducerRest {

    @Autowired
    private ProducerService producerService;

    @PostMapping
    public void enviarData(
            @RequestBody DataDto modelo
    ){
        producerService.enviar(modelo);
    }
}

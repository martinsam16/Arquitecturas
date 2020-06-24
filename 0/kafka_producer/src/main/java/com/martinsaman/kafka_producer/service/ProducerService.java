package com.martinsaman.kafka_producer.service;

import com.martinsaman.kafka_producer.dto.DataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, DataDto> kafkaTemplate;

    @Value("${topic.name}")
    private String topicName;

    public void enviar(DataDto modelo) {
        kafkaTemplate.send(topicName, modelo);
    }


}

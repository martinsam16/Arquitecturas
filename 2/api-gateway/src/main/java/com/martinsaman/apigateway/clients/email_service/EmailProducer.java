package com.martinsaman.apigateway.clients.email_service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.email}")
    private String topicName;

    private void enviar(String mensaje) {
        kafkaTemplate.send(topicName, mensaje);
    }

    public void enviar(EmailDto emailDto) {
        Gson gson = new Gson();
        this.enviar(gson.toJson(emailDto));
    }
}

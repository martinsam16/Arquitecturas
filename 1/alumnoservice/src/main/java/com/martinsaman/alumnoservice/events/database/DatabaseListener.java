package com.martinsaman.alumnoservice.events.database;

import com.google.gson.Gson;
import com.martinsaman.alumnoservice.events.actions.PersonaAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DatabaseListener {

    @Autowired
    private PersonaAction personaAction;

    @KafkaListener(topics = "#{'${topic.db-events}'.split(',')}", groupId = "com.martinsaman")
    public void consume(String message) {
        try {
            DatabaseDto dto = new Gson().fromJson(message, DatabaseDto.class);
            System.out.println("RECIBIDO:" + dto);
            accionDatabase(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void accionDatabase(DatabaseDto dto) {
        switch (dto.getTypeModel()) {
            case PERSONA:
                personaAction.accion(dto);
                break;
            default:
                System.out.println("NADA");
                break;
        }
    }

}

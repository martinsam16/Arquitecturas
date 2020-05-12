package com.martinsaman.personaservice.events;

import lombok.Data;

@Data
public class DatabaseDto {
    private DatabaseEvent databaseEvent;
    private Object idModel;
    private Object model;
}

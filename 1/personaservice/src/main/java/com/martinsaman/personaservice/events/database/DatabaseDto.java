package com.martinsaman.personaservice.events.database;

import lombok.Data;

@Data
public class DatabaseDto {
    private DatabaseEvent databaseEvent;
    private Object model;
    private Object idModel;
    // Sólo harán algo a los que les interese el model especificado
    private DatabaseModel typeModel;

    public DatabaseDto() {
    }

    public DatabaseDto(DatabaseEvent databaseEvent, Object model, Object idModel, DatabaseModel typeModel) {
        this.databaseEvent = databaseEvent;
        this.idModel = idModel;
        this.model = model;
        this.typeModel = typeModel;
    }
}

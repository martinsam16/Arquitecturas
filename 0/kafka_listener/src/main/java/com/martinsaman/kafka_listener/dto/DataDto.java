package com.martinsaman.kafka_listener.dto;

import com.martinsaman.kafka_listener.type.CollectionDatabase;
import com.martinsaman.kafka_listener.type.DatabaseAction;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataDto {
    private CollectionDatabase collectionDatabase;
    private DatabaseAction action;
    private Object data;
}

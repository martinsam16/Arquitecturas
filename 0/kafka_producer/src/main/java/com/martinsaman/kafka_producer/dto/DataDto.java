package com.martinsaman.kafka_producer.dto;

import com.martinsaman.kafka_producer.type.CollectionDatabase;
import com.martinsaman.kafka_producer.type.DatabaseAction;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataDto {
    private CollectionDatabase collectionDatabase;
    private DatabaseAction action;
    private Object data;
}

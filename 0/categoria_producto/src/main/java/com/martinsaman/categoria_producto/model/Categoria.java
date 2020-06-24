package com.martinsaman.categoria_producto.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Categoria {
    @Id
    private String id;
    private String nombre;
    private String estado;
}

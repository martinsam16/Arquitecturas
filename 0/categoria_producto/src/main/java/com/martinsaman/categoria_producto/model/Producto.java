package com.martinsaman.categoria_producto.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Producto {

    @Id
    private String id;
    private String nombre;
    private Double precio;
    private String estado;
    private Categoria categoria;
}

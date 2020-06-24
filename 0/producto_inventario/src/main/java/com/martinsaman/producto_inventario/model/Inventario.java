package com.martinsaman.producto_inventario.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Inventario {

    @Id
    private String id;
    private Producto producto;
    private Integer cantidad;
    private String tipo;

    @Transient
    public Double total(){
        return producto.getPrecio() * cantidad;
    }
}

package com.martinsaman.courseservice.usuario_curso.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class UsuarioCurso {
    @Id
    private String _id;

    private List<ObjectId> cursosUsuario;

    @CreatedDate
    private Date createdAt;

    public UsuarioCurso() {
    }


}

package com.martinsaman.courseservice.curso.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Curso {
    @Id
    private String _id;
    private String author;
    private String name;
    private String image;
    private String description;

    @CreatedDate
    private Date createdAt;
}

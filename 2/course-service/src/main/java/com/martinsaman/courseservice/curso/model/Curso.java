package com.martinsaman.courseservice.curso.model;

import com.martinsaman.courseservice.curso.dto.CursoDto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Curso {
    @Id
    private String _id;
    private String author;
    @Indexed(unique = true)
    private String name;
    private String image;
    private String description;
    @CreatedDate
    private Date createdAt;

    public Curso() {
    }

    public Curso(String author, String name, String image, String description) {
        this.author = author;
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

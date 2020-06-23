package com.martinsaman.courseservice.curso.model;

import com.martinsaman.courseservice.curso.dto.CursoDto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
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
    private Float price;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date lastModified;

    public Curso() {
    }

    public Curso(CursoDto dto) {
        this.author = dto.getAuthor();
        this.name = dto.getName();
        this.image = dto.getImage();
        this.description = dto.getDescription();
        this.price = dto.getPrice();
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

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "_id='" + _id + '\'' +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", lastModified=" + lastModified +
                '}';
    }
}

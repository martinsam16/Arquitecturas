package com.martinsaman.courseservice.curso.dto;

public class CursoDto {
    private String author;
    private String name;
    private String image;
    private String description;

    public CursoDto() {
    }

    public CursoDto(String author, String name, String image, String description) {
        this.author = author;
        this.name = name;
        this.image = image;
        this.description = description;
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
}

package com.martinsaman.apigateway.clients.email_service;

import com.martinsaman.apigateway.clients.curso_service.curso.Curso;

import java.util.List;
import java.util.stream.Collectors;

public class EmailDto {
    private String email;
    private String subject;
    private String content;

    public EmailDto(String email) {
        this.email = email;
    }

    public void mensajeBienvenida() {
        this.subject = "Bienvenido a la Biblio";
        this.content = "Hola, te has suscrito recientemente; asi que te damos la bienvenida a nuestra plataforma :D \n" +
                "https://i.pinimg.com/originals/74/64/2d/74642d8702d9643428b138e49b202b49.jpg";
    }

    public void mensajeCursosInfo(List<Curso> cursosComprados) {
        this.subject = "Cursos comprados :D";
        this.content = "Información: \n \n" + cursosComprados.stream()
                .map((curso) -> "Nombre: " + curso.getName() + "\n" +
                        "Autor: " + curso.getAuthor() + "\n" +
                        "Descripción: " + curso.getDescription() + "\n" +
                        "Precio: " + curso.getPrice() + "$ \n"
                )
                .collect(Collectors.joining("\n ----- \n "));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EmailDto{" +
                "email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

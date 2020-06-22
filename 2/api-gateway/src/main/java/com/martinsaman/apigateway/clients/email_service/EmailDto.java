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
        this.content = "Un wen floro :D";
    }

    public void mensajeCompra(List<Curso> cursosComprados) {
        this.subject = "Compra realizada con exito :D";
        this.content = "Compra realizada: " + cursosComprados.stream()
                .map(Curso::getName)
                .collect(Collectors.joining(", "));
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

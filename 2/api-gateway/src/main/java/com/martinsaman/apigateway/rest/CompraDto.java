package com.martinsaman.apigateway.rest;

import com.martinsaman.apigateway.clients.curso_service.curso.Curso;

import java.util.List;

public class CompraDto {
    private String email;
    private List<Curso> cursosComprar;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Curso> getCursosComprar() {
        return cursosComprar;
    }

    public void setCursosComprar(List<Curso> cursosComprar) {
        this.cursosComprar = cursosComprar;
    }
}

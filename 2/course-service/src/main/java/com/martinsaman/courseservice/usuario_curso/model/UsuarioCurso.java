package com.martinsaman.courseservice.usuario_curso.model;

import com.martinsaman.courseservice.curso.model.Curso;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class UsuarioCurso {
    @Id
    private String _id;

    @DBRef
    private List<Curso> cursos;

    @CreatedDate
    private Date createdAt;

    public UsuarioCurso() {
    }

    public UsuarioCurso(String _id, List<Curso> cursos) {
        this._id = _id;
        this.cursos = cursos;
    }

    public UsuarioCurso(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

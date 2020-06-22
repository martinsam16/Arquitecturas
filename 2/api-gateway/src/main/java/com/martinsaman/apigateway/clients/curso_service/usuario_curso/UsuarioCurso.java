package com.martinsaman.apigateway.clients.curso_service.usuario_curso;

import com.martinsaman.apigateway.clients.curso_service.curso.Curso;

import java.util.Date;
import java.util.List;

public class UsuarioCurso {
    private String _id;
    private List<Curso> cursos;
    private Date createdAt;

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

    @Override
    public String toString() {
        return "UsuarioCurso{" +
                "_id='" + _id + '\'' +
                ", cursos=" + cursos +
                ", createdAt=" + createdAt +
                '}';
    }
}

package com.martinsaman.apigateway.clients.curso_service.usuario_curso;

import com.martinsaman.apigateway.clients.usuario_service.Usuario;

public class UsuarioCursoDto {
    private UsuarioCurso usuarioCurso;
    private Usuario usuario;

    public UsuarioCursoDto() {
    }

    public UsuarioCursoDto(UsuarioCurso usuarioCurso, Usuario usuario) {
        this.usuarioCurso = usuarioCurso;
        this.usuario = usuario;
    }

    public UsuarioCurso getUsuarioCurso() {
        return usuarioCurso;
    }

    public void setUsuarioCurso(UsuarioCurso usuarioCurso) {
        this.usuarioCurso = usuarioCurso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

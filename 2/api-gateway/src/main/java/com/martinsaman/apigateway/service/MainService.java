package com.martinsaman.apigateway.service;

import com.martinsaman.apigateway.clients.curso_service.curso.Curso;
import com.martinsaman.apigateway.clients.curso_service.curso.CursoDto;
import com.martinsaman.apigateway.clients.curso_service.usuario_curso.CursoClient;
import com.martinsaman.apigateway.clients.curso_service.usuario_curso.UsuarioCurso;
import com.martinsaman.apigateway.clients.curso_service.usuario_curso.UsuarioCursoClient;
import com.martinsaman.apigateway.clients.email_service.EmailDto;
import com.martinsaman.apigateway.clients.email_service.EmailProducer;
import com.martinsaman.apigateway.clients.usuario_service.Usuario;
import com.martinsaman.apigateway.clients.usuario_service.UsuarioClient;
import com.martinsaman.apigateway.clients.usuario_service.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MainService {

    @Autowired
    private CursoClient cursoClient;
    @Autowired
    private UsuarioCursoClient usuarioCursoClient;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private EmailProducer emailProducer;

    public List<UsuarioCurso> listarUsuarioCurso() {
        return usuarioCursoClient.listar();
    }

    public List<Usuario> listarUsuarios() {
        return usuarioClient.listar();
    }

    public Usuario guardarUsuario(UsuarioDto dto) {
        return usuarioClient.guardarUsuario(dto);
    }

    public List<Curso> listarCursos() {
        return cursoClient.listar();
    }

    public Curso guardarCurso(CursoDto cursoDto) {
        return cursoClient.guardar(cursoDto);
    }

    public void comprarCurso(String email, List<Curso> cursosComprar) {
        Usuario usuario = usuarioClient.requestUser(email);
        EmailDto emailDto = new EmailDto(email);


        UsuarioCurso usuarioCurso = new UsuarioCurso();
        usuarioCurso.set_id(usuario.get_id());
        usuarioCurso.setCursos(cursosComprar);
        usuarioCurso = usuarioCursoClient.guardarActualizar(usuarioCurso);

        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        if (fmt.format(usuario.getCreatedAt()).equals(fmt.format(new Date()))) {
            emailDto.mensajeBienvenida();
            emailProducer.enviar(emailDto);
        }

        List<Curso> lista = new ArrayList<>();
        for (Curso curso : cursosComprar) {
            lista.add(usuarioCurso.getCursos().get(usuarioCurso.getCursos().indexOf(curso)));
        }


        emailDto.mensajeCursosInfo(lista);
        emailProducer.enviar(emailDto);

    }

}

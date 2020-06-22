package com.martinsaman.apigateway.service;

import com.martinsaman.apigateway.clients.curso_service.curso.Curso;
import com.martinsaman.apigateway.clients.curso_service.curso.CursoDto;
import com.martinsaman.apigateway.clients.curso_service.usuario_curso.CursoClient;
import com.martinsaman.apigateway.clients.curso_service.usuario_curso.UsuarioCurso;
import com.martinsaman.apigateway.clients.curso_service.usuario_curso.UsuarioCursoClient;
import com.martinsaman.apigateway.clients.usuario_service.Usuario;
import com.martinsaman.apigateway.clients.usuario_service.UsuarioClient;
import com.martinsaman.apigateway.clients.usuario_service.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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

    public UsuarioCurso comprarCurso(String email, List<Curso> cursosComprar) {
        Usuario usuario = usuarioClient.requestUser(email);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        if (fmt.format(usuario.getCreatedAt()).equals(fmt.format(new Date()))) {
//            Enviar mensaje de nuevo
            System.out.println("Bienvenido :DDDDDDDDDDDDDDDDDDDDD");
        }
        UsuarioCurso usuarioCurso = new UsuarioCurso();
        usuarioCurso.set_id(usuario.get_id());
        usuarioCurso.setCursos(cursosComprar);
        System.out.println(usuarioCurso);
        usuarioCurso = usuarioCursoClient.guardarActualizar(usuarioCurso);
//        Enviar mensaje de compra
        System.out.println("Compra exitosa :DDDDDDDDDDDD");

        System.out.println(usuario);
        System.out.println(usuarioCurso);
        return usuarioCurso;
    }

}

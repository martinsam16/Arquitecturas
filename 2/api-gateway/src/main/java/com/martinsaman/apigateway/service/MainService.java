package com.martinsaman.apigateway.service;

import com.martinsaman.apigateway.clients.curso_service.curso.Curso;
import com.martinsaman.apigateway.clients.curso_service.curso.CursoClient;
import com.martinsaman.apigateway.clients.curso_service.curso.CursoDto;
import com.martinsaman.apigateway.clients.curso_service.usuario_curso.UsuarioCurso;
import com.martinsaman.apigateway.clients.curso_service.usuario_curso.UsuarioCursoClient;
import com.martinsaman.apigateway.clients.curso_service.usuario_curso.UsuarioCursoDto;
import com.martinsaman.apigateway.clients.email_service.EmailDto;
import com.martinsaman.apigateway.clients.email_service.EmailProducer;
import com.martinsaman.apigateway.clients.usuario_service.Usuario;
import com.martinsaman.apigateway.clients.usuario_service.UsuarioClient;
import com.martinsaman.apigateway.clients.usuario_service.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<UsuarioCursoDto> listarUsuarioCurso() {
        return usuarioCursoClient.listar()
                .stream()
                .map((uc) -> {
                    Optional<Usuario> usuario = Optional.empty();
                    try {
                        usuario = Optional.ofNullable(usuarioClient.obtenerUsuarioId(uc.get_id()));
                    } catch (Exception ignored) {
                    }
                    return new UsuarioCursoDto(uc, usuario.orElse(null));
                })
                .collect(Collectors.toList());
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
        try {


            Usuario usuario = usuarioClient.requestUser(email);
            EmailDto emailDto = new EmailDto(email);
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
            if (fmt.format(usuario.getCreatedAt()).equals(fmt.format(new Date()))) {
                emailDto.mensajeBienvenida();
                emailProducer.enviar(emailDto);
            }

            cursosComprar = cursosComprar.stream()
                    .map((curso) -> cursoClient.buscarPorId(curso.get_id())).collect(Collectors.toList());

            UsuarioCurso usuarioCurso = new UsuarioCurso();
            usuarioCurso.set_id(usuario.get_id());
            usuarioCurso.setCursos(cursosComprar);
            usuarioCursoClient.guardarActualizar(usuarioCurso);


            emailDto.mensajeCursosInfo(cursosComprar);
            emailProducer.enviar(emailDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

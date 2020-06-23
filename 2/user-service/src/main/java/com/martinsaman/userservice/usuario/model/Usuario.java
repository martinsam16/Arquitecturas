package com.martinsaman.userservice.usuario.model;

import com.martinsaman.userservice.usuario.dto.UsuarioDto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Usuario {
    @Id
    private String _id;
    private String email;
    private String name;
    private Date birthDay;
    @CreatedDate
    private Date createdAt;

    public Usuario() {
    }

    public Usuario(String email) {
        this.email = email;
    }

    public Usuario(String email, String name, Date birthDay) {
        this.email = email;
        this.name = name;
        this.birthDay = birthDay;
    }

    public Usuario(UsuarioDto dto) {
        this.email = dto.getEmail();
        this.name = dto.getName();
        this.birthDay = dto.getBirthDay();
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

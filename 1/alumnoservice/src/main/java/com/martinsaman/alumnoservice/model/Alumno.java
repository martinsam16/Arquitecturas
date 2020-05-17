package com.martinsaman.alumnoservice.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Alumno implements Serializable {
    @Id
    private Integer IDALUM;
    private Date FECMAT;
    private String ESTALUM;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Persona persona;
}

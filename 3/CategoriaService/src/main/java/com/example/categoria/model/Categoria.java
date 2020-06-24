package com.example.categoria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CATEGORIA")
@Data
public class Categoria implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDCAT;

    @Column(length = 50, nullable = false)
    private String NOMCAT;

    @Column(length = 1, nullable = false)
    private String ESTCAT = "A";

}

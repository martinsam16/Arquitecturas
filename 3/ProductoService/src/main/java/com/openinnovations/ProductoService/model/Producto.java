package com.openinnovations.ProductoService.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "PRODUCTO")
@Data
public class Producto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IDPROD;

    @Column(length = 50, nullable = false)
    private String NOMPROD;

    @Column(nullable = false)
    private Double PREPROD;

    @Transient //Para que sea ignorado en la persistencia
    private Categoria categoria;

    private Long IDCAT;

    @Column(length = 1, nullable = false)
    private String ESTPROD;

    public void setearIdCategoria(){
        this.IDCAT = this.categoria.getIDCAT();
    }

}

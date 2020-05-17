package com.martinsaman.alumnoservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Persona implements Serializable {

    @Id
    private Integer IDPER;
    private String NOMPER;
    private String APEPATPER;
    private String APEMATPER;
    private String DNIPER;
    private String ESTPER;
}

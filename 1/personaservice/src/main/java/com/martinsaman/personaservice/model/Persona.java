package com.martinsaman.personaservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Persona {
    @Id
    private String id;
    private Integer IDPER;
    private String NOMPER;
    private String APEPATPER;
    private String APEMATPER;
    private String DNIPER;
    private String ESTPER;

    public Persona() {
    }

    public Persona(Integer IDPER, String NOMPER, String APEPATPER, String APEMATPER, String DNIPER, String ESTPER) {
        this.IDPER = IDPER;
        this.NOMPER = NOMPER;
        this.APEPATPER = APEPATPER;
        this.APEMATPER = APEMATPER;
        this.DNIPER = DNIPER;
        this.ESTPER = ESTPER;
    }
}

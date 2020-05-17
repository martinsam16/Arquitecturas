package com.martinsaman.alumnoservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AlumnoDto {
    private Integer IDPER;
    private Integer IDALUM;
    private Date FECMAT;
    private String ESTALUM;
}

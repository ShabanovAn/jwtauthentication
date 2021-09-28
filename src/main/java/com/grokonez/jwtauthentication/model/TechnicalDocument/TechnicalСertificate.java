package com.grokonez.jwtauthentication.model.TechnicalDocument;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class TechnicalСertificate {
    @Formula("0")
    private Long id;
    @Formula("0")
    private String serviceDate;
    @Formula("0")
    private int serialNumber;
    @Formula("0")
    private boolean decorated; //Флаг Растаможки
}

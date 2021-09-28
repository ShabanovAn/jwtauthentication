package com.grokonez.jwtauthentication.model.TechnicalDocument;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.Embeddable;

@Embeddable //Встраиваемая таблица(в другую таблицу)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Engine {
    @Formula("0")
    private Long id;
    @Formula("0")
    private int maxSpeed;
    @Formula("0")
    private int horsePower;
    @Formula("0")
    private int yearOfIssue;

}

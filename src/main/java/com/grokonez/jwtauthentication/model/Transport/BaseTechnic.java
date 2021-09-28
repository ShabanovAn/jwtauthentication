package com.grokonez.jwtauthentication.model.Transport;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
//@MappedSuperclass //Когда наследование от не entity
@Entity
@Inheritance
@DiscriminatorColumn(name = "technic_type")
public class BaseTechnic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private int ear;
}

package com.grokonez.jwtauthentication.model.Transport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grokonez.jwtauthentication.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
@DiscriminatorValue("CAR") //
public class Car extends BaseTechnic{

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}

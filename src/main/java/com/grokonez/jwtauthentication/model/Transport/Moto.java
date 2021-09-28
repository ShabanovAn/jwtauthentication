package com.grokonez.jwtauthentication.model.Transport;

import com.grokonez.jwtauthentication.model.TechnicalDocument.Engine;
import com.grokonez.jwtauthentication.model.TechnicalDocument.TechnicalСertificate;
import com.grokonez.jwtauthentication.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "moto")
@DiscriminatorValue("MOTO")
public class Moto extends BaseTechnic{

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "user_id", nullable = false)
        private User user;
       // @Null//
        @Embedded
        @AttributeOverrides(value = {
                @AttributeOverride(name ="id", column = @Column(name ="engine_id"))
        })
        private Engine engine;


        @Embedded
        @AttributeOverrides(value = {
                @AttributeOverride(name = "id", column = @Column(name = "technicalcertificate_id"))
        })
        private TechnicalСertificate technicalСertificate;
}

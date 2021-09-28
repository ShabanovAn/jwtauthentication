package com.grokonez.jwtauthentication.repository.TransportRepository;

import com.grokonez.jwtauthentication.model.Transport.Moto;
import com.grokonez.jwtauthentication.repository.FindTechnic;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends FindTechnic<Moto> {

}

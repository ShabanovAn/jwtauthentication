package com.grokonez.jwtauthentication.repository.TransportRepository;

import com.grokonez.jwtauthentication.model.Transport.Helicopter;
import com.grokonez.jwtauthentication.repository.FindTechnic;
import org.springframework.stereotype.Repository;

@Repository
public interface HelicopterRepository extends FindTechnic<Helicopter> {

}

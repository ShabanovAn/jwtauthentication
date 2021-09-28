package com.grokonez.jwtauthentication.repository.TransportRepository;

import com.grokonez.jwtauthentication.model.Transport.Car;
import com.grokonez.jwtauthentication.repository.FindTechnic;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends FindTechnic<Car> {

}

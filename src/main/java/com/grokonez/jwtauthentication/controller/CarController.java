package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.exception.CarException;
import com.grokonez.jwtauthentication.model.Transport.Car;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.TransportRepository.CarRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/car")
public class CarController {

    private CarRepository carRepository;

    private UserRepository userRepository;

    @GetMapping
    public List<Car> findAll(Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();
        return carRepository.findByUser(user);
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) throws Exception {
        return carRepository.findById(id).orElseThrow(()->new CarException("Car not found"));
    }

    @PostMapping
    //  SecurityContextHolder.getContext().setAuthentication(authentication);
    public Car addCar(@RequestBody Car car, Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();
        car.setUser(user);
        return carRepository.save(car);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }


    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
        return "deleted Car " + id;

    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car carNew) {
        Car carOld = carRepository.getOne(id);
        carOld.setModel(carNew.getModel());
        carOld.setEar(carNew.getEar());
        return carRepository.save(carNew);
    }

}

package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.Transport.Helicopter;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.TransportRepository.HelicopterRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/helicopter")
public class HelicopterController {

    private HelicopterRepository helicopterRepository;

    private UserRepository userRepository;

    @GetMapping
    public List<Helicopter> findAll(Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();
        return helicopterRepository.findByUser(user);
    }

    @PostMapping
    public Helicopter addHelicopter(@RequestBody Helicopter helicopter, Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();
        helicopter.setUser(user);
        return helicopterRepository.save(helicopter);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Helicopter> getAllHelicopter(Principal principal) {
        return helicopterRepository.findAll();}
}

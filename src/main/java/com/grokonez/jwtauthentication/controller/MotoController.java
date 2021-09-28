package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.TechnicalDocument.Engine;
import com.grokonez.jwtauthentication.model.TechnicalDocument.TechnicalСertificate;
import com.grokonez.jwtauthentication.model.Transport.Moto;
import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.TransportRepository.MotoRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/moto")
public class MotoController {

    private MotoRepository motoRepository;

    private UserRepository userRepository;

    @GetMapping
    public List<Moto> findAll(Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();
        return motoRepository.findByUser(user);
    }

    @PostMapping
    public Moto addMoto(@RequestBody Moto moto, Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();
        moto.setUser(user);
        return motoRepository.save(moto);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Moto> getAllMoto(){return motoRepository.findAll();}

    @GetMapping("/{model}")
    public List<Moto> findByModel(@PathVariable String model) {
        return motoRepository.findByModel(model);
    }

    @PostMapping("/engine/{motoid}")
    public Moto eddEngineToMoto(Principal principal,
                              @RequestBody Engine engine, @PathVariable Long motoid) {
        //User user = userRepository.findByUsername(principal.getName()).get();
        Moto moto = motoRepository.findById(motoid).get();
        moto.setEngine(engine);
        return motoRepository.save(moto);
    }

    @PostMapping("/technicalcertificate/{motoid}")
    public Moto addTechnicalCertificate(Principal principal,
                                        @RequestBody TechnicalСertificate technicalСertificate,
                                        @PathVariable Long motoid) {
        Moto moto = motoRepository.findById(motoid).get();
        moto.setTechnicalСertificate(technicalСertificate);
        return motoRepository.save(moto);
    }

//    @GetMapping("/order/{id}")
//    public List<Moto> findAllOrderByModel(@PathVariable Long id) {
//        return motoRepository.findAllOrderByMod(id);
//
//    }
}

package com.coronadoportfolio.coronado.service;

import com.coronadoportfolio.coronado.model.Persona;
import com.coronadoportfolio.coronado.repository.PersonaRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaService implements IPersonaService{

    @Autowired
    public PersonaRepository persoRepo;
    
    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public Persona findPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }

    @Override
    public void newPersona(Persona pers) {
        persoRepo.save(pers);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public void updatePersona(Persona pers) {
        persoRepo.save(pers);
    }     
    
}

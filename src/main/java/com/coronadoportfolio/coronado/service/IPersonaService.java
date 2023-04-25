package com.coronadoportfolio.coronado.service;

import com.coronadoportfolio.coronado.model.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> verPersonas();
    
    public Persona findPersona(Long id);
    
    public void newPersona(Persona pers);
    
    public void deletePersona(Long id);
    
    public void updatePersona(Persona pers);
}

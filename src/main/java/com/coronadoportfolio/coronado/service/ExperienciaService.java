
package com.coronadoportfolio.coronado.service;

import com.coronadoportfolio.coronado.model.Experiencia;
import com.coronadoportfolio.coronado.repository.ExperienciaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    
    @Autowired
    ExperienciaRepository experienciaRepository;
    
    public List<Experiencia> list(){
        return experienciaRepository.findAll();
    }
    
    public Optional<Experiencia> traeUno(Long id){
        return experienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getByLugarExp(String lugarExp){
        return experienciaRepository.findByLugarExp(lugarExp);
    }
    
    public void save(Experiencia exp){
        experienciaRepository.save(exp);
    }
    
    public void delete(Long id){
        experienciaRepository.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return experienciaRepository.existsById(id);
    }
    public boolean existsByLugarExp(String lugarExp){
        return experienciaRepository.existsByLugarExp(lugarExp);
    }
    
}
    
    
    
    
    
    
    
    



package com.coronadoportfolio.coronado.service;

import com.coronadoportfolio.coronado.model.Skill;
import com.coronadoportfolio.coronado.repository.SkillRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillService {
    @Autowired
    SkillRepository skillRepository;
    
    public List<Skill> listaSkill(){
        return skillRepository.findAll();
    }
    
    public Optional<Skill> encuentraSkillId(Long id){
        return skillRepository.findById(id);
    }
    
    public Optional<Skill> encuentraTitulo(String titulo){
        return skillRepository.findByTitulo(titulo);
    }
    
    public boolean existeSkillId(Long id){
        return skillRepository.existsById(id);
    }
    
    public boolean existeTitulo(String titulo){
        return skillRepository.existsByTitulo(titulo);
    }       
    
    public void salvarSkill(Skill skill){
        skillRepository.save(skill);
    }
    
    public void borrarSkillId(Long id){
        skillRepository.deleteById(id);
    }
    
}

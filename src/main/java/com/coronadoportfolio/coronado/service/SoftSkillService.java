
package com.coronadoportfolio.coronado.service;

import com.coronadoportfolio.coronado.model.SoftSkill;
import com.coronadoportfolio.coronado.repository.SoftSkillRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SoftSkillService {    
    @Autowired
    SoftSkillRepository softSkillRepository;
    
    public List<SoftSkill> listaSoft(){
        return softSkillRepository.findAll();        
    }      
    
    public Optional<SoftSkill> encuentraSoftSkillId(Long id){
        return softSkillRepository.findById(id);
    }
    
    public Optional<SoftSkill> encuentraSoftSkill(String softSkill){
        return softSkillRepository.findBySoftSkill(softSkill);
    }
    
    public boolean existeSoftSkill(String softSkill){
        return softSkillRepository.existsBySoftSkill(softSkill);
    }
    
    public boolean existeSoftSkillId(Long id){
        return softSkillRepository.existsById(id);
    }
    
    public void salvarSoftSkill(SoftSkill softSkill){
        softSkillRepository.save(softSkill);
    }
    public void borrarSoftSkill(Long id){
        softSkillRepository.deleteById(id);
    }
    
}

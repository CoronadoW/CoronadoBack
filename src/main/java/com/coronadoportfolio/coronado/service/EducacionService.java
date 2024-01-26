
package com.coronadoportfolio.coronado.service;

import com.coronadoportfolio.coronado.model.Educacion;
import com.coronadoportfolio.coronado.repository.EducacionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    @Autowired
    EducacionRepository educacionRepository;
    
    public List<Educacion> listaEdu(){
        return educacionRepository.findAll();
    }
    
    public Optional<Educacion> encuentraId(Long id){
        return educacionRepository.findById(id);
    }
    
     public Optional<Educacion> encuentraLugarEdu(String lugarEdu){
        return educacionRepository.findByLugarEdu(lugarEdu);
    }
     
    public boolean existeId(Long id){
        return educacionRepository.existsById(id);
    }
    
    public boolean existeLugarEdu(String lugarEdu){
        return educacionRepository.existsByLugarEdu(lugarEdu);
    }
    
    public void salvarEdu(Educacion edu){
        educacionRepository.save(edu);
    }
    
    public void borraId(Long id){
        educacionRepository.deleteById(id);
    }      
    
}


package com.coronadoportfolio.coronado.security.Service;

import com.coronadoportfolio.coronado.security.Entity.Rol;
import com.coronadoportfolio.coronado.security.Enums.RolNombre;
import com.coronadoportfolio.coronado.security.Repository.IRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
 
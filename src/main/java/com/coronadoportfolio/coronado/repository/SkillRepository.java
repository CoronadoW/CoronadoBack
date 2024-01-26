
package com.coronadoportfolio.coronado.repository;

import com.coronadoportfolio.coronado.model.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SkillRepository  extends JpaRepository<Skill, Long>{
    public Optional<Skill> findByTitulo(String titulo);
    public boolean existsByTitulo(String titulo);
    
}

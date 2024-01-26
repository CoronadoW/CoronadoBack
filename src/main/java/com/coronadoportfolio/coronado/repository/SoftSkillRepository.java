
package com.coronadoportfolio.coronado.repository;

import com.coronadoportfolio.coronado.model.SoftSkill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SoftSkillRepository extends JpaRepository<SoftSkill, Long>{
    public Optional<SoftSkill> findBySoftSkill(String softSkill);
    public boolean existsBySoftSkill(String softSkill);
}

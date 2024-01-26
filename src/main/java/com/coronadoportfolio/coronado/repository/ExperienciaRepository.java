
package com.coronadoportfolio.coronado.repository;

import com.coronadoportfolio.coronado.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExperienciaRepository extends JpaRepository<Experiencia,Long> {
    public Optional<Experiencia>findByLugarExp(String lugarExp);
    public boolean existsByLugarExp(String lugarExp);
}

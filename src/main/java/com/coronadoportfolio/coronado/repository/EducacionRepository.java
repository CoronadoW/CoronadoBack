
package com.coronadoportfolio.coronado.repository;

import com.coronadoportfolio.coronado.model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EducacionRepository extends JpaRepository <Educacion, Long>{
    public Optional<Educacion> findByLugarEdu(String lugarEdu);
    public boolean existsByLugarEdu(String lugarEdu);
}

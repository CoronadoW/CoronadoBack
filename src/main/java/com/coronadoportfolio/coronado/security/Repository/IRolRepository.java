
package com.coronadoportfolio.coronado.security.Repository;

import com.coronadoportfolio.coronado.security.Entity.Rol;
import com.coronadoportfolio.coronado.security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}

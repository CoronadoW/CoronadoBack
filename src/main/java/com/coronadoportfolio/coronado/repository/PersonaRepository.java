
package com.coronadoportfolio.coronado.repository;

import com.coronadoportfolio.coronado.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long>{
    
}


/*
<Persona,Long>
Persona por que es la primer clase que tenemos en el entity
y el primer objeto es un Long
*/
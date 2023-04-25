
package com.coronadoportfolio.coronado.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String titulo;
    private String img;
    
    public Persona(){        
    }
    
    public Persona(long id, String nombre, String titulo, String img){
        this.id=id;
        this.nombre=nombre;
        this.titulo=titulo;
        this.img= img;
    }
}

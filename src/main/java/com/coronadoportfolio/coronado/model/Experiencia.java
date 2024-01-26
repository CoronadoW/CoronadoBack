
package com.coronadoportfolio.coronado.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Experiencia {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lugarExp;
    private String descripcionExp;
    private String anioExp;
    private String imgExp;

    public Experiencia() {
    }

    public Experiencia( String lugarExp, String descripcionExp, String anioExp, String imgExp) {
        this.lugarExp = lugarExp;
        this.descripcionExp = descripcionExp;
        this.anioExp = anioExp;
        this.imgExp = imgExp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLugarExp() {
        return lugarExp;
    }

    public void setLugarExp(String lugarExp) {
        this.lugarExp = lugarExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

    public String getAnioExp() {
        return anioExp;
    }

    public void setAnioExp(String anioExp) {
        this.anioExp = anioExp;
    }

    public String getImgExp() {
        return imgExp;
    }

    public void setImgExp(String imgExp) {
        this.imgExp = imgExp;
    }
    
    
       
 }

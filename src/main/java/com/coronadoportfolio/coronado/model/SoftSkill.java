
package com.coronadoportfolio.coronado.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SoftSkill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String softSkill;
    private Long softPorcentaje;
    private String softInnerColor;
    private String softOuterColor;
    
    public SoftSkill(){
        
    }
   
    public SoftSkill(String softSkill, Long softPorcentaje, String softInnerColor, String softOuterColor ){
        
        this.softSkill = softSkill;
        this.softPorcentaje =  softPorcentaje;
        this.softInnerColor = softInnerColor;
        this.softOuterColor = softOuterColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoftSkill() {
        return softSkill;
    }

    public void setSoftSkill(String softSkill) {
        this.softSkill = softSkill;
    }

    public Long getSoftPorcentaje() {
        return softPorcentaje;
    }

    public void setSoftPorcentaje(Long softPorcentaje) {
        this.softPorcentaje = softPorcentaje;
    }

    public String getSoftInnerColor() {
        return softInnerColor;
    }

    public void setSoftInnerColor(String softInnerColor) {
        this.softInnerColor = softInnerColor;
    }

    public String getSoftOuterColor() {
        return softOuterColor;
    }

    public void setSoftOuterColor(String softOuterColor) {
        this.softOuterColor = softOuterColor;
    }
    
    
    
}


package com.coronadoportfolio.coronado.Dto;

import javax.validation.constraints.NotBlank;


public class SkillDto {
    
    @NotBlank
    private String titulo;
    @NotBlank
    private Long porcentaje;
    private String innerColor;
    private String outerColor;
    
    public SkillDto(){
     }
    
    public SkillDto(String titulo,Long porcentaje, String innerColor, String outerColor){
        this.titulo = titulo;
        this.porcentaje = porcentaje;
        this.innerColor = innerColor;
        this.outerColor = outerColor;
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Long porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getInnerColor() {
        return innerColor;
    }

    public void setInnerColor(String innerColor) {
        this.innerColor = innerColor;
    }

    public String getOuterColor() {
        return outerColor;
    }

    public void setOuterColor(String outerColor) {
        this.outerColor = outerColor;
    }

    
   
}

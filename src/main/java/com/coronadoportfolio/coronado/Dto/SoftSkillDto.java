
package com.coronadoportfolio.coronado.Dto;

import javax.validation.constraints.NotBlank;


public class SoftSkillDto {
    @NotBlank
    private String softSkill;
    @NotBlank
    private Long softPorcentaje;
    private String softInnerColor;
    private String softOuterColor;
    
    public SoftSkillDto(){
        
    }
    
    public SoftSkillDto(String softSkill, Long softPorcentaje, String softInnerColor, String softOuterColor){
        this.softSkill = softSkill;
        this.softPorcentaje = softPorcentaje;
        this.softInnerColor = softInnerColor;
        this.softOuterColor = softOuterColor;
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

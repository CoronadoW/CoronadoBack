


package com.coronadoportfolio.coronado.Dto;

import javax.validation.constraints.NotBlank;


public class ExperienciaDto {
    
    @NotBlank
    private String lugarExp;
    @NotBlank
    private String descripcionExp;
    @NotBlank
    private String anioExp;
    private String imgExp;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String lugarExp, String descripcionExp, String anioExp, String imgExp) {
        this.lugarExp = lugarExp;
        this.descripcionExp = descripcionExp;
        this.anioExp = anioExp;
        this.imgExp = imgExp;
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

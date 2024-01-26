
package com.coronadoportfolio.coronado.Dto;

import javax.validation.constraints.NotBlank;


public class EducacionDto {
    
    @NotBlank
    private String lugarEdu;
    @NotBlank
    private String descripcionEdu;
    @NotBlank
    private String anioEdu;
    @NotBlank
    private String imgEdu;
    
    public EducacionDto(){
    }
    public EducacionDto(String lugarEdu, String descripcionEdu, String anioEdu, String imgEdu){
        this.lugarEdu = lugarEdu;
        this.descripcionEdu = descripcionEdu;
        this.anioEdu = anioEdu;
        this.imgEdu = imgEdu;
    }

    public String getLugarEdu() {
        return lugarEdu;
    }

    public void setLugarEdu(String lugarEdu) {
        this.lugarEdu = lugarEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

    public String getAnioEdu() {
        return anioEdu;
    }

    public void setAnioEdu(String anioEdu) {
        this.anioEdu = anioEdu;
    }

    public String getImgEdu() {
        return imgEdu;
    }

    public void setImgEdu(String imgEdu) {
        this.imgEdu = imgEdu;
    }
    
            
}


package com.coronadoportfolio.coronado.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lugarEdu;
    private String descripcionEdu;
    private String anioEdu;
    private String imgEdu;
    
    public Educacion (){
    }
    public Educacion(String lugarEdu, String descripcionEdu, String anioEdu, String imgEdu){
        this.lugarEdu = lugarEdu;
        this.descripcionEdu = descripcionEdu;
        this.anioEdu = anioEdu;
        this.imgEdu = imgEdu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

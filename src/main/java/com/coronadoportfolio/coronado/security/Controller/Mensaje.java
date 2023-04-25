package com.coronadoportfolio.coronado.security.Controller;

public class Mensaje {

    private String mensaje;

    //constructores
    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    //setters y getters
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}

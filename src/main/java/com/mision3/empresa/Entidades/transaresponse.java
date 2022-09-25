package com.mision3.empresa.Entidades;

public class transaresponse {
    private String mensaje;
    private Object objeto;

    public transaresponse() {
    }

    public transaresponse(String mensaje, Object objeto) {
        this.mensaje = mensaje;
        this.objeto = objeto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

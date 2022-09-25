package com.mision3.empresa.Entidades;

public class empleresponse {
    private String mensaje;
    private Object objeto;

    public empleresponse() {
    }

    public empleresponse(String mensaje, Object objeto) {
        this.mensaje = mensaje;
        this.objeto = objeto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
}

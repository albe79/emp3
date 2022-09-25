package com.mision3.empresa.Entidades;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    @Column
    private String imagen;
    @Column(unique = true)
    private String clave;

    public Usuario() {
    }



    public Usuario(String correo, String imagen, String clave) {
        this.email = correo;
        this.imagen = imagen;
        this.clave = clave;
    }





    public String getEmail() {
        return email;
    }

    public void setCorreo(String correo) {
        this.email = correo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}

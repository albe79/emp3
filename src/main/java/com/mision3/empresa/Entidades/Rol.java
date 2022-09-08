package com.mision3.empresa.Entidades;

import javax.persistence.*;

@Table(name = "rol")
public enum Rol {

    Administrador, Operativo;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Empleado.class)
    @JoinColumn(name = "id_emple")
    private Empleado empleado;
}

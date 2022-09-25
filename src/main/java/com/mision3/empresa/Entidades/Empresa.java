package com.mision3.empresa.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idempr;
    @Column
    private String nombre;
    @Column
    private String nit;
    @Column
    private String telefono;
    @Column
    private String direccion;
    @Column
    private LocalDate creado;
    @JsonIgnore
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
    private List<Empleado> listempleados;
    @JsonIgnore
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
    private List<Transaccion> listmovimientos;

    public Empresa() {
    }

    public Empresa(Long idempr, String nombre, String nit, String telefono, String direccion, LocalDate creado, List<Empleado> listempleados, List<Transaccion> listmovimientos) {
        this.idempr = idempr;
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.creado = creado;
        this.listempleados = listempleados;
        this.listmovimientos = listmovimientos;
    }

    public Long getIdempr() {
        return idempr;
    }

    public void setIdempr(Long idempr) {
        this.idempr = idempr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Empleado> getListempleados() {
        return listempleados;
    }

    public void setListempleados(List<Empleado> listempleados) {
        this.listempleados = listempleados;
    }

    public List<Transaccion> getListmovimientos() {
        return listmovimientos;
    }

    public void setListmovimientos(List<Transaccion> listmovimientos) {
        this.listmovimientos = listmovimientos;
    }

    public LocalDate getCreado() {
        return creado;
    }

    public void setCreado(LocalDate creado) {
        this.creado = creado;
    }


}

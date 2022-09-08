package com.mision3.empresa.Entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idempr;
    @Column(name="nombre")
    private String nombre;
    @Column(name="nit")
    private String nit;
    @Column(name="telefono")
    private String telefono;
    @Column(name="direccion")
    private String direccion;
    @Column(name="creado")
    private LocalDate creado;
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
    private List<Empleado> listempleados;
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
    private List<Transaccion> listmovimientos;

    public Empresa() {
    }

    public Empresa(Long idempr, String nombre, String nit, String telefono, String direccion, LocalDate creado) {
        this.idempr = idempr;
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.creado = creado;
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





    public LocalDate getCreado() {
        return creado;
    }

    public void setCreado(LocalDate creado) {
        this.creado = creado;
    }
}

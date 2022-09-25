package com.mision3.empresa.Entidades;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String concepto;
    @Column
    private Float monto;
    @Column
    LocalDate creacion;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Empleado.class)
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Empresa.class)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
    public Transaccion() {
    }

    public Transaccion(Long id, String concepto, Float monto, LocalDate creacion, Empleado empleado, Empresa empresa) {
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
        this.creacion = creacion;
        this.empleado = empleado;
        this.empresa = empresa;
    }

    public Transaccion(String concepto, Float monto, LocalDate creacion, Empleado empleado, Empresa empresa) {
        this.concepto = concepto;
        this.monto = monto;
        this.creacion = creacion;
        this.empleado = empleado;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public LocalDate getCreacion() {
        return creacion;
    }

    public void setCreacion(LocalDate creacion) {
        this.creacion = creacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}

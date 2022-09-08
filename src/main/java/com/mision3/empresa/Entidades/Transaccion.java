package com.mision3.empresa.Entidades;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="concepto")
    private String concepto;
    @Column(name="monto")
    private float monto;
    @Column(name="creacion")
    LocalDate creacion;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Empleado.class)
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Empresa.class)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
    public Transaccion() {
    }

    public Transaccion( String concepto, float monto, LocalDate creacion) {
        this.concepto = concepto;
        this.monto = monto;
        this.creacion = creacion;
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
}

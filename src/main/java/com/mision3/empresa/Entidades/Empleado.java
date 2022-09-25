package com.mision3.empresa.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column(unique = true)

    private String email;
    @Column
    private LocalDate creado;
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Empresa.class)
    @JoinColumn(name = "idempr")
    private Empresa empresa;
    @JsonIgnore
    @OneToMany(mappedBy = "empleado",cascade = CascadeType.ALL)
    private List<Transaccion> listmovimientos;
    @Enumerated(EnumType.STRING)
    @Column
    private Rol rol;
    public Empleado() {
    }

    public Empleado(Long id, String nombre, String email, LocalDate creado, Empresa empresa, List<Transaccion> listmovimientos, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.creado = creado;
        this.empresa = empresa;
        this.listmovimientos = listmovimientos;
        this.rol = rol;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreado() {
        return creado;
    }

    public void setCreado(LocalDate creado) {
        this.creado = creado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public List<Transaccion> getListmovimientos() {
        return listmovimientos;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}

package com.mision3.empresa.Servicios;

import com.mision3.empresa.Entidades.Empleado;
import com.mision3.empresa.Repositorio.repoempleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class servicioempleado {
    private repoempleado em;
    @Autowired
    public void setRepositorio(repoempleado emp){this.em = emp;}
    public Empleado guardaremp(Empleado empleado){
        return em.save(empleado);
    }
    public List<Empleado> buscaempl(){
     return this.em.findAll();
    }
    public boolean existsByIdEmpleado(Long id){
        return em.existsById(id);
    }
    public Empleado empleadoid(Long id){
        Optional<Empleado> emp = this.em.findById(id);
        return emp.orElse(null);
    }

    public void borrar(Long id) {
        em.deleteById(id);
    }
    public Empleado actualizaemp(Empleado empleado){
        return em.save(empleado);
    }


}

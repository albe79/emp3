package com.mision3.empresa.Servicios;

import com.mision3.empresa.Entidades.Empleado;
import com.mision3.empresa.Entidades.Empresa;
import com.mision3.empresa.Repositorio.repoempleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class servicioempleado {
    @Autowired
    private repoempleado em;

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
    public Empleado actualiemple(Long id, String nombre) {
        Optional<Empleado> emple = em.findById(id);
        if(emple.isPresent()){
            Empleado e = emple.get();
            e.setNombre(nombre);
            return e;
        }
        return null;
    }
   /* public Optional<Empleado> empleid(Long id){
        return em.findById(id);
    }*/
   public Empleado patempleado(Empleado emple, Long id) throws Exception {
       try {
           Empleado empldb = empleadoid(id);
           if(emple.getEmail()!=null){
               empldb.setEmail(emple.getEmail());
           }
           if(emple.getNombre()!=null){
               empldb.setNombre(emple.getNombre());
           }
           if(emple.getCreado()!=null){
               empldb.setCreado(emple.getCreado());
           }

           return guardaremp(empldb);
       }catch(Exception e){
           throw new Exception("empleado inexistente");
       }
   }
    public String borra(Long id){
        em.deleteById(id);
        return "eliminado";
    }

}

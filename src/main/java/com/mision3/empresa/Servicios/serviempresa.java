package com.mision3.empresa.Servicios;

import com.mision3.empresa.Entidades.Empleado;
import com.mision3.empresa.Entidades.Empresa;
import com.mision3.empresa.Entidades.Transaccion;
import com.mision3.empresa.Repositorio.repoempleado;
import com.mision3.empresa.Repositorio.repoempresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class serviempresa {
    @Autowired
    private repoempresa rem;

    public void setRepositorio(repoempresa empr){this.rem = empr;}
    public List<Empresa> buscaemp(){
        List<Empresa> empresas = rem.findAll();
        return empresas;
    }
    public Empresa guardaremp(Empresa empresa){
        return rem.save(empresa);
    }

    public boolean existsByIdEmpresa(Long id){
        return rem.existsById(id);
    }
    public Optional<Empresa> empresaid(Long id){
        return rem.findById(id);
    }
    public Empresa empreid(Long id) throws Exception {
        Optional<Empresa> empr = this.rem.findById(id);
        if (empr.isPresent()) {
            return empr.get();
        } else {
            throw new Exception("no existe");
        }
    }
    public void borrar(Long id) {
        rem.deleteById(id);
    }
    public String borra(Long id){
        rem.deleteById(id);
        return "eliminado";
    }
    public Empresa actualizaemp(Empresa empresa){
        return rem.save(empresa);
    }
    public Empresa actualiempre(Long id, String telefono) {
        Optional<Empresa> empre = rem.findById(id);
        if(empre.isPresent()){
            Empresa em = empre.get();
            em.setTelefono(telefono);
            return em;
        }
        return null;
    }
    public Empresa patempresa(Empresa empre, Long id) throws Exception {
        try {
            Empresa empdb = empreid(id);
            if(empre.getNit()!=null){
                empdb.setNit(empre.getNit());
            }
            if(empre.getNombre()!=null){
                empdb.setNombre(empre.getNombre());
            }
            if(empre.getDireccion()!=null){
                empdb.setDireccion(empre.getDireccion());
            }
            if(empre.getTelefono()!=null){
                empdb.setTelefono(empre.getTelefono());
            }
            if(empre.getCreado()!=null){
                empdb.setCreado(empre.getCreado());
            }
            return guardaremp(empdb);
        }catch(Exception e){
       throw new Exception("empresa inexistente");
        }
    }
}

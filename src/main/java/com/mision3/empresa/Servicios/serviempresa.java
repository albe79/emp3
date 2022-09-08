package com.mision3.empresa.Servicios;

import com.mision3.empresa.Entidades.Empleado;
import com.mision3.empresa.Entidades.Empresa;
import com.mision3.empresa.Repositorio.repoempleado;
import com.mision3.empresa.Repositorio.repoempresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class serviempresa {
    private repoempresa rem;
    @Autowired
    public void setRepositorio(repoempresa empr){this.rem = empr;}
    public Empresa guardaremp(Empresa empresa){
        return rem.save(empresa);
    }
    public List<Empresa> buscaemp(){
        return rem.findAll();
    }
    public boolean existsByIdEmpresa(Long id){
        return rem.existsById(id);
    }
    public Optional<Empresa> empresaid(Long id){
        return rem.findById(id);
    }
    public Empresa empreid(Long id){
        Optional<Empresa> empr = this.rem.findById(id);
        return empr.orElse(null);
    }
    public void borrar(Long id) {
        rem.deleteById(id);
    }
    public Empresa actualizaemp(Empresa empresa){
        return rem.save(empresa);
    }
}

package com.mision3.empresa.Servicios;

import com.mision3.empresa.Entidades.Empleado;
import com.mision3.empresa.Entidades.Transaccion;
import com.mision3.empresa.Repositorio.repoempleado;
import com.mision3.empresa.Repositorio.repotransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Servitransaccion {
    private repotransaccion ret;
    @Autowired
    public void setRepositorio(repotransaccion rt){this.ret = rt;}
    public Transaccion guardatransac(Transaccion transa){
        return ret.save(transa);
    }
    public List<Transaccion> buscatrans(){
        return ret.findAll();
    }
    public boolean existsByIdTransaccion(Long id){
        return ret.existsById(id);
    }
    public Optional<Transaccion> transaccionid(Long id){
        return ret.findById(id);
    }
    public Transaccion transacid(Long id){
        Optional<Transaccion> trans = this.ret.findById(id);
        return trans.orElse(null);
    }
    public void borrar(Long id) {
        ret.deleteById(id);
    }
    public Transaccion actualiztrans(Transaccion transaccion){
        return ret.save(transaccion);
    }
}

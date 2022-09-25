package com.mision3.empresa.Servicios;

import com.mision3.empresa.Entidades.Empleado;
import com.mision3.empresa.Entidades.Empresa;
import com.mision3.empresa.Entidades.Transaccion;
import com.mision3.empresa.Repositorio.repoempleado;
import com.mision3.empresa.Repositorio.repotransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Servitransaccion {
    @Autowired
    private repotransaccion ret;

   // public void setRepositorio(repotransaccion rt){this.ret = rt;}
    public Transaccion guardatransac(Transaccion transa){
        return ret.save(transa);
    }
    public List<Transaccion> buscatrans(){
        List<Transaccion> listr = ret.findAll();
        return listr;
    }
    public boolean existsByIdTransaccion(Long id){
        return ret.existsById(id);
    }
    public Transaccion transaccionid(Long id){
        Optional<Transaccion> trans = this.ret.findById(id);
        return trans.orElse(null);
    }
    public Transaccion transaid(Long id) throws Exception {
        Optional<Transaccion> tr = this.ret.findById(id);
        if (tr.isPresent()) {
            return tr.get();
        } else {
            throw new Exception("no existe");
        }
    }
    public void borrar(Long id) {
        ret.deleteById(id);
    }
    public Transaccion actualiztrans(Transaccion transaccion){
        return ret.save(transaccion);
    }

    public Transaccion actualizaconcepto(Long id, String concepto) {
        Optional<Transaccion> trans = ret.findById(id);
        if(trans.isPresent()){
            Transaccion tr = trans.get();
            tr.setConcepto(concepto);
            return tr;
        }
        return null;
    }
    public String borra(Long id){
        ret.deleteById(id);
        return "eliminado";
    }
    public Transaccion pattransa(Transaccion tr, Long id) throws Exception {
        try {
            Transaccion trandb = transaid(id);
            if(tr.getConcepto()!=null){
                trandb.setConcepto(tr.getConcepto());
            }
            if(tr.getMonto()!= 0.0){
                trandb.setMonto(tr.getMonto());
            }
            if(tr.getCreacion()!=null){
                trandb.setCreacion(tr.getCreacion());
            }

            return guardatransac(trandb);
        }catch(Exception e){
            throw new Exception("transaccion inexistente");
        }
    }
}

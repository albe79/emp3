package com.mision3.empresa.Servicios;


import com.mision3.empresa.Entidades.Usuario;
import com.mision3.empresa.Repositorio.repousuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class serviusuario {
    @Autowired
    repousuario ru;

    public serviusuario(repousuario ru) {
        this.ru = ru;
    }
    public Usuario crearusu(Usuario nuevousu){
        return ru.save(nuevousu);
    }
    public Usuario fyndUserByEmail(String email)  {
        return ru.findByEmail(email);
    }
    public Usuario usuaut(Map<String,Object> userData) throws Exception {
        String email = (String) userData.get("email");
        Usuario usua = this.fyndUserByEmail(email);
        if(usua==null) {
            //String name =(String)userData.get("nickname");
            String imagen = (String) userData.get("picture");
            String clave = (String) userData.get("sub");

            Usuario nuevo = new Usuario(email = email, imagen = imagen, clave = clave);
            return crearusu(nuevo);
        }
        System.out.println(email);
        return usua;

    }
}

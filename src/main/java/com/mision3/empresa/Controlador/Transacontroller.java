package com.mision3.empresa.Controlador;

import com.mision3.empresa.Entidades.Empleado;
import com.mision3.empresa.Entidades.Transaccion;
import com.mision3.empresa.Servicios.Servitransaccion;
import com.mision3.empresa.Servicios.servicioempleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaccion")
public class Transacontroller {
    @Autowired
    private Servitransaccion st;
    @PostMapping("/guardar")
    public ResponseEntity<Transaccion> guardatrans(@RequestBody Transaccion transaccion){
        return ResponseEntity.status(HttpStatus.CREATED).body(st.guardatransac(transaccion));
    }
    @GetMapping("/lista")
    public List<Transaccion> buscatrans(){
        return this.st.buscatrans();
    }

    @GetMapping("/transaccion/{id}")
    public Transaccion buscaid(@PathVariable("id")Long id){
        return this.st.transacid(id);
    }
    @DeleteMapping("transaccion/{id}")
    public String borratrans(@PathVariable("id") Long id){
        st.borrar(id);
        return "eliminado";

    }
    @PutMapping("/actual")
    public ResponseEntity<Transaccion> actualitrans(@RequestBody Transaccion transaccion){
        return ResponseEntity.status(HttpStatus.CREATED).body(st.actualiztrans(transaccion));
    }
}

package com.mision3.empresa.Controlador;

import com.mision3.empresa.Entidades.*;
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
        public ResponseEntity<List<Transaccion>> listatransaccion(){
            return new ResponseEntity<List<Transaccion>>(
                    st.buscatrans(),
                    HttpStatus.OK
            );
    }

    @GetMapping("/transaccion/{id}")
    public ResponseEntity<Object> buscaid(@PathVariable Long id) {
        try {
            Transaccion tr = st.transaid(id);
            return new ResponseEntity<>(tr, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
    @PatchMapping("/{id}/{concepto}")
    public Transaccion actualizaconcepto(@PathVariable("id") Long id, @PathVariable("concepto") String concepto){
        return st.actualizaconcepto(id,concepto);
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<transaresponse> borrar(@PathVariable Long id){
        return new ResponseEntity<>(new transaresponse(st.borra(id),null),HttpStatus.OK);
    }
    @PatchMapping("/pat/{id}")
    public ResponseEntity<transaresponse> pattransaccion(@RequestBody Transaccion tr,@PathVariable Long id) {

        try {
            return new ResponseEntity<>(new transaresponse("patch actualizado",st.pattransa(tr,id)),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new transaresponse(e.getMessage(),null),HttpStatus.OK);
        }
    }

}

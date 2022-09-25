package com.mision3.empresa.Controlador;

import com.mision3.empresa.Entidades.*;
import com.mision3.empresa.Servicios.servicioempleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/empleado")
public class Empleadocontroller {
  @Autowired
  private servicioempleado se;
  @PostMapping("/guardar")
  public ResponseEntity<Empleado> guardarempl(@RequestBody Empleado empleado){
      return ResponseEntity.status(HttpStatus.CREATED).body(se.guardaremp(empleado));
  }
  @GetMapping("/lista")
  public List<Empleado> buscarempl(){
      return this.se.buscaempl();
  }

 /* @GetMapping("/empleado/{id}")
  public Empleado buscaid(@PathVariable("id")Long id){
    return this.se.empleadoid(id);
  }*/
/*@DeleteMapping("empleado/{id}")
    public String borracliente(@PathVariable("id") Long id){
      se.borrar(id);
      return "eliminado";

}*/
    @PatchMapping("/{id}/{nombre}")
    public Empleado actualizanombre(@PathVariable("id") Long id, @PathVariable("nombre") String nombre){
        return se.actualiemple(id, nombre);
    }
@PutMapping("/actual")
public ResponseEntity<Empleado> actualempl(@RequestBody Empleado empleado){
    return ResponseEntity.status(HttpStatus.CREATED).body(se.actualizaemp(empleado));
}
    @GetMapping("/empleado/{id}")
    public ResponseEntity<Object> buscaid(@PathVariable Long id){
        try {
            Empleado em = se.empleadoid(id);
            return new ResponseEntity<>(em,HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PatchMapping("/pat/{id}")
    public ResponseEntity<empresponse> patchempleado(@RequestBody Empleado em, @PathVariable Long id) {

        try {
            return new ResponseEntity<>(new empresponse("patch actualizado",se.patempleado(em,id)),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new empresponse(e.getMessage(),null),HttpStatus.OK);
        }
    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<empleresponse> borrar(@PathVariable Long id){
        return new ResponseEntity<>(new empleresponse(se.borra(id),null),HttpStatus.OK);
    }
}

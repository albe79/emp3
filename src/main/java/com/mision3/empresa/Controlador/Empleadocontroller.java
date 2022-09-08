package com.mision3.empresa.Controlador;

import com.mision3.empresa.Entidades.Empleado;
import com.mision3.empresa.Servicios.servicioempleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping("/empleado/{id}")
  public Empleado buscaid(@PathVariable("id")Long id){
    return this.se.empleadoid(id);
  }
@DeleteMapping("empleado/{id}")
    public String borracliente(@PathVariable("id") Long id){
      se.borrar(id);
      return "eliminado";

}
@PutMapping("/actual")
public ResponseEntity<Empleado> actualempl(@RequestBody Empleado empleado){
    return ResponseEntity.status(HttpStatus.CREATED).body(se.actualizaemp(empleado));
}
}

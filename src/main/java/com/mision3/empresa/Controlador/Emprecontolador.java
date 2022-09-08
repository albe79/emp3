package com.mision3.empresa.Controlador;


import com.mision3.empresa.Entidades.Empresa;
import com.mision3.empresa.Servicios.serviempresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class Emprecontolador {
    @Autowired
    private serviempresa se;
    @PostMapping("/guardar")
    public ResponseEntity<Empresa> guardarempl(@RequestBody Empresa empresa){
        return ResponseEntity.status(HttpStatus.CREATED).body(se.guardaremp(empresa));
    }
    @GetMapping("/lista")
    public List<Empresa> buscarempl(){
        return this.se.buscaemp();
    }

    @GetMapping("/empresa/{id}")
    public Empresa buscaid(@PathVariable("id")Long id){
        return this.se.empreid(id);
    }
    @DeleteMapping("empresa/{id}")
    public String borraempresa(@PathVariable("id") Long id){
        se.borrar(id);
        return "eliminada";

    }
    @PutMapping("/actual")
    public ResponseEntity<Empresa> actualempr(@RequestBody Empresa empresa){
        return ResponseEntity.status(HttpStatus.CREATED).body(se.actualizaemp(empresa));
    }
}

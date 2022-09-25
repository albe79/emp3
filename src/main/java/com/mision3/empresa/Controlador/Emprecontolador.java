package com.mision3.empresa.Controlador;


import com.mision3.empresa.Entidades.Empresa;
import com.mision3.empresa.Entidades.empresponse;
import com.mision3.empresa.Servicios.serviempresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class Emprecontolador {
    @Autowired
    private serviempresa se;
    @PostMapping("/guardar")
    public RedirectView creatarea(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Empresa ta,Model model){
        model.addAttribute(ta);
        this.se.guardaremp(ta);
        return new RedirectView("/Categorias");
    }
   /* @PostMapping("/guardar")
//    public ResponseEntity<empresponse> guardarempr(@RequestBody Empresa empresa)
    public RedirectView guardarempr(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Empresa empresa, Model modelo){
        modelo.addAttribute(empresa);
        new ResponseEntity<>(new empresponse("creado",se.guardaremp(empresa)),HttpStatus.OK);
        se.guardaremp(empresa);
        return new RedirectView("/Categorias");

    }*/
   /* @GetMapping("/lista")
    public ResponseEntity<List<Empresa>> buscarempr(){
        return new ResponseEntity<List<Empresa>>(
                se.buscaemp(),
                HttpStatus.OK
        );
    }*/
    @GetMapping("/empresas")
    public ResponseEntity<Object> buscaidquery(@RequestParam Long id){
        try {
            Empresa em = se.empreid(id);
            return new ResponseEntity<>(em,HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/empresa/{id}")
    public ResponseEntity<Object> buscaid(@PathVariable Long id){
        try {
            Empresa em = se.empreid(id);
            return new ResponseEntity<>(em,HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("empresa/{id}")
    public String borraempresa(@PathVariable("id") Long id){
        se.borrar(id);
        return "eliminada";

    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<empresponse> borrar(@PathVariable Long id){
    return new ResponseEntity<>(new empresponse(se.borra(id),null),HttpStatus.OK);
    }
    @PutMapping("/actual")
    public empresponse actualempr(@RequestBody Empresa empresa){
        return new empresponse("actualizado",se.actualizaemp(empresa));
    }
    @PatchMapping("/{id}/{telefono}")
    public Empresa actualizaconcepto(@PathVariable("id") Long id, @PathVariable("telefono") String telefono){
        return se.actualiempre(id, telefono);
    }
    @PatchMapping("/pat/{id}")
    public ResponseEntity<empresponse> patchempresa(@RequestBody Empresa em,@PathVariable Long id) {

        try {
            return new ResponseEntity<>(new empresponse("patch actualizado",se.patempresa(em,id)),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new empresponse(e.getMessage(),null),HttpStatus.OK);
        }
    }
    }



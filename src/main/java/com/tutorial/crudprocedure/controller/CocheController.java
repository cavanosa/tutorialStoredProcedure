package com.tutorial.crudprocedure.controller;

import com.tutorial.crudprocedure.entity.Coche;
import com.tutorial.crudprocedure.service.CocheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coche")
public class CocheController {

    @Autowired
    CocheService cocheService;

    @GetMapping("/lista")
    public ResponseEntity<List<Coche>> lista(){
        List<Coche> lista = cocheService.lista();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/verid/{id}")
    public ResponseEntity<Coche> verId(@PathVariable("id") int id){
        Optional<Coche> coche = cocheService.getById(id);
        return new ResponseEntity(coche, HttpStatus.OK);
    }

    @GetMapping("/vermarca/{marca}")
    public ResponseEntity<List<Coche>> verMarca(@PathVariable("marca") String marca){
        List<Coche> coches = cocheService.getByMarca(marca);
        return new ResponseEntity(coches, HttpStatus.OK);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> save(@RequestBody Coche coche){
        cocheService.saveProcedure(coche);
        return new ResponseEntity("coche guardado", HttpStatus.CREATED);
    }

    @GetMapping("/media")
    public ResponseEntity<Float> mediaKm(){
        float media = cocheService.mediaKm();
        return new ResponseEntity(media, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable("id")int id){
        cocheService.borrarProcedure(id);
        return new ResponseEntity("coche eliminado", HttpStatus.OK);
    }

}

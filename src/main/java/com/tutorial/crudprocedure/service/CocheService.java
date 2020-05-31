package com.tutorial.crudprocedure.service;


import com.tutorial.crudprocedure.entity.Coche;
import com.tutorial.crudprocedure.repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocheService {

    @Autowired
    CocheRepository cocheRepository;

    public List<Coche> lista(){
        return cocheRepository.listaProcedure();
    }

    public Optional<Coche> getById(int id){
        return cocheRepository.idProcedure(id);
    }

    public List<Coche> getByMarca(String marca){
        return cocheRepository.marcaProcedure(marca);
    }

    public void saveProcedure(Coche coche){
        cocheRepository.saveProcedure(coche.getMarca(), coche.getModelo(), coche.getAnyo(), coche.getKm());
    }

    public float mediaKm(){
        return cocheRepository.mediaKm();
    }

    public void borrarProcedure(int id){
        cocheRepository.borrarProcedure(id);
    }
}

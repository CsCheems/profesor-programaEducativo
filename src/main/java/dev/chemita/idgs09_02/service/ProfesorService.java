package dev.chemita.idgs09_02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.chemita.idgs09_02.model.entity.Profesor;
import dev.chemita.idgs09_02.model.repository.ProfesorRepo;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepo pRepo;
    
    @Transactional(readOnly = true)
    public List<Profesor> findAll(){
        return pRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Profesor> findById(int id_prof){
        return pRepo.findById(id_prof);
    }

    @Transactional
    public Profesor save (Profesor p){
        return pRepo.save(p);
    }

    @Transactional
    public void deleteById(int id_prof){
        pRepo.deleteById(id_prof);
    }
}

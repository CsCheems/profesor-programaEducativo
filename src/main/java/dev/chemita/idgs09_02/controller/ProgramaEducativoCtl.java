package dev.chemita.idgs09_02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.chemita.idgs09_02.model.entity.Profesor;
import dev.chemita.idgs09_02.model.entity.ProgramaEducativo;
import dev.chemita.idgs09_02.model.repository.ProfesorRepo;
import dev.chemita.idgs09_02.model.repository.ProgramaEducativoRepo;

@RestController
@RequestMapping("/api/programaEducativo")   
public class ProgramaEducativoCtl {
    
    @Autowired
    private ProgramaEducativoRepo peRepo;
    @Autowired
    private ProfesorRepo pRepo;

    @GetMapping
    public List<ProgramaEducativo> buscarTodos(@RequestParam boolean soloActivos){
        if(soloActivos){
            return peRepo.findAll().stream().filter(ProgramaEducativo::isActivo).toList();
        }
        return peRepo.findAll();
    }

    @GetMapping("/{id_prof}")
    public ProgramaEducativo buscarPorId(@PathVariable int id_prog){
        return peRepo.findById(id_prog).get();
    }

    @PostMapping 
    public ResponseEntity<?> crear(@RequestParam int id_prof, @RequestBody ProgramaEducativo pe){
        Optional<Profesor> opt = pRepo.findById(id_prof);
        if(opt.isPresent()){
            Profesor p = opt.get();
            pe.setProfesor(p);
            return ResponseEntity.ok(peRepo.save(pe));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<?> editar(@RequestParam int id_prof, @RequestParam int id_prog, @RequestBody ProgramaEducativo peEntity){
        Optional<Profesor> optDiv = pRepo.findById(id_prof);
        Optional<ProgramaEducativo> optPe = peRepo.findById(id_prog);
        if(optDiv.isPresent()){
            ProgramaEducativo pe = optPe.get();
            pe.setClave(peEntity.getClave());
            pe.setNombre(peEntity.getNombre());
            pe.setActivo(peEntity.isActivo());
            return ResponseEntity.ok(peRepo.save(pe));
        }
        return ResponseEntity.notFound().build();
    }

}

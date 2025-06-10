package dev.chemita.idgs09_02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import dev.chemita.idgs09_02.model.entity.Profesor;
import dev.chemita.idgs09_02.model.repository.ProfesorRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/profesor")
public class profesorCtl {
    
    @Autowired
    private ProfesorRepo pRepo;

    @GetMapping()
    public List<Profesor> buscarTodos() {
        return pRepo.findAll();
    }

    @GetMapping("/{id_prof}")
    public Profesor buscarPorId(@PathVariable int id_prof) {
        return pRepo.findById(id_prof).get();
    }
    
    @PostMapping
    public ResponseEntity<?> crearProfesor(@RequestBody Profesor p) {
        Profesor entity = pRepo.save(p);
        return ResponseEntity.ok(entity);
    }

    @PutMapping("/{id_prof}")
    public ResponseEntity<?> editar(@PathVariable int id_prof, @RequestBody Profesor entity) {
        Optional<Profesor> opt = pRepo.findById(id_prof);
        if(opt.isPresent()){
            Profesor p = opt.get();
            p.setNombre(entity.getNombre());
            p.setApellidos(entity.getApellidos());
            p.setGenero(entity.getGenero());
            p.setClavePE(entity.getClavePE());
            p.setActivo(entity.isActivo());
            return ResponseEntity.ok(pRepo.save(p));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_prof}")
    public ResponseEntity<?> borrar(@PathVariable int id_prof){
        Optional<Profesor> opt = pRepo.findById(id_prof);
        if(opt.isPresent()){
            pRepo.deleteById(id_prof);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
    
}

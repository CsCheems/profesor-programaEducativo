package dev.chemita.idgs09_02.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.chemita.idgs09_02.model.entity.Profesor;

public interface ProfesorRepo extends JpaRepository<Profesor, Integer>{
    
}

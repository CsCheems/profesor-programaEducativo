package dev.chemita.idgs09_02.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Profesor {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prof;
    private String nombre;
    private String apellidos;
    private String genero;
    private String clavePE;
    private boolean activo;

}



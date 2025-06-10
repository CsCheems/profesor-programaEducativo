package dev.chemita.idgs09_02.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ProgramaEducativo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prog;
    private String nombre;
    private String clave;
    private boolean activo;
    @ManyToOne
    @JoinColumn(name = "clavePE")
    @JsonIgnoreProperties(value = "programaEducativo")
    private Profesor profesor;

    
}

package dev.chemita.idgs09_02.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}

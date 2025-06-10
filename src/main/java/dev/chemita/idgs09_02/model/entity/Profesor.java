package dev.chemita.idgs09_02.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Profesor {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prof;
    private String nombre;
    private String apellidos;
    private boolean genero;
    private String clavePE;
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesor")
    private List<ProgramaEducativo> programaEducativo;
}

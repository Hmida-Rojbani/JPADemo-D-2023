package de.tekup.jpademo.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dateDebut;
    private LocalDate dateRetour;
    private double prixJour;
    @Transient
    private double prix;
    @ManyToOne
    private ClientEntity client;
}

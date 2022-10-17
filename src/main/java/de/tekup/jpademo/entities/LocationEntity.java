package de.tekup.jpademo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.IntSequenceGenerator.class)
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

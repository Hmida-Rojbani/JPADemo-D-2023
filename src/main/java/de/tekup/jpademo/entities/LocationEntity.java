package de.tekup.jpademo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@Entity
@Table(name="lct_tbl")
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
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
    @ManyToOne
    private VoitureEntity voiture;

    @PostLoad
    private void calulatePrix(){
         long nbDays = ChronoUnit.DAYS
                 .between(dateDebut,dateRetour.plusDays(1));
        prix = prixJour*nbDays;
    }
}

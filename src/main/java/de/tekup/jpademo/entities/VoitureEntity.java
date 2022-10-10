package de.tekup.jpademo.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class VoitureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serie;

    private LocalDate dateDeMiseEnMarche;
    private String model;

}

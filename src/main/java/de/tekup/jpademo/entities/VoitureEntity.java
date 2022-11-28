package de.tekup.jpademo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="voit_tbl")
@JsonIdentityInfo(property = "id",generator = ObjectIdGenerators.PropertyGenerator.class)
public class VoitureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String serie;
    @PastOrPresent
    private LocalDate dateDeMiseEnMarche;
    @NotBlank
    private String model;

    private String vendor;
    @Positive
    private double prixDeJour;
    private String imagePath;


    @OneToMany(mappedBy = "voiture")
    List<LocationEntity> locations;

    public String getDateHTML() {
        return dateDeMiseEnMarche==null?"":dateDeMiseEnMarche.toString();
    }

    public void setDateHTML(String dateHTML) {
        this.dateDeMiseEnMarche = LocalDate.parse(dateHTML);
    }
}

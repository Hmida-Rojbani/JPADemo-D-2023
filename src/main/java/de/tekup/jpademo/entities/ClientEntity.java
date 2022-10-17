package de.tekup.jpademo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
@Data
@JsonIdentityInfo(property = "cin",generator = ObjectIdGenerators.PropertyGenerator.class)
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private Integer cin;
    @Column(length = 50,nullable = false)
    private String nom;

    private String prenom;
    private String adress;

    @OneToMany(mappedBy = "client")
    List<LocationEntity> locations;




}

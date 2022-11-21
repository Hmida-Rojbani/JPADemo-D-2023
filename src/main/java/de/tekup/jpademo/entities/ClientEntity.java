package de.tekup.jpademo.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "client")
@Data
@JsonIdentityInfo(property = "cin",generator = ObjectIdGenerators.PropertyGenerator.class)
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,length = 8)
    @Pattern(regexp = "^[0-9]{8}$",message = "CIN must contains only digits")
    @Size(min = 8,max = 8, message = "CIN must be exactly 8 digits")
    private String cin;
    @Column(length = 50,nullable = false)
    @NotBlank
    @Size(min = 3, max = 50)
    private String nom;
    @Size(max = 50)
    private String prenom;
    private String adress;

    @OneToMany(mappedBy = "client")
    List<LocationEntity> locations;




}

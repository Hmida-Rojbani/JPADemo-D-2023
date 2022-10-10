package de.tekup.jpademo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "client")
@Data
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





}

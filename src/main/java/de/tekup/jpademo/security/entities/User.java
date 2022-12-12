package de.tekup.jpademo.security.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String name;
    @NotBlank
    @Column(unique = true)
    private String username;
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    @Size(min = 4)
    private String password;
    @Transient
    private String repeatPassword;
    @Enumerated(value = EnumType.STRING)
    private Role role;

}

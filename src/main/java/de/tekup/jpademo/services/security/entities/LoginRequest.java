package de.tekup.jpademo.services.security.entities;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}

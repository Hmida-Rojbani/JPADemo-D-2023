package de.tekup.jpademo.security.controllers;

import de.tekup.jpademo.security.entities.User;
import de.tekup.jpademo.security.services.TokenService;
import de.tekup.jpademo.security.services.UserService;
import de.tekup.jpademo.services.security.entities.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuthCtrl {
    private AuthenticationManager authManager;
    private TokenService tokenService;
    private UserService userService;

    @PostMapping("/token")
    public String token(@RequestBody LoginRequest loginRequest) throws AuthenticationException {
        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        return tokenService.generateToken(authentication);
    }

    @PostMapping("/register")
    public String registerPagePost(@Valid @RequestBody User user){
        
        userService.registerUser(user);
        
        return "User Registered";
    }
}

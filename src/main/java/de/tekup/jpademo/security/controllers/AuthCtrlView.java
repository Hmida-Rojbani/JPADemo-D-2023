package de.tekup.jpademo.security.controllers;

import de.tekup.jpademo.security.entities.User;
import de.tekup.jpademo.security.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class AuthCtrlView {
    private UserService userService;

    @GetMapping("/signup")
    public String registerPage(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }
    @PostMapping("/signup")
    public String registerPagePost(@Valid @ModelAttribute("user") User user,
                                   BindingResult result){
        if(result.hasErrors()){
            return "signup";
        }
        userService.registerUser(user);
        return "redirect:/";
    }

    @GetMapping("/signin")
    public String loginPage(Model model){
        return "signin";
    }

    @GetMapping("/rent")
    public String rentPage(Model model, Principal principal){
        model.addAttribute("user", userService.userByUsername(principal.getName()));
        return "rent";
    }
}

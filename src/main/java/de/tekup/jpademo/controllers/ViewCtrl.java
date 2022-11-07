package de.tekup.jpademo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewCtrl {
    @GetMapping({"/","/index"})
    public String landingPage(){
        return "index";
    }

    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }
}

package de.tekup.jpademo.controllers;

import de.tekup.jpademo.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients/ui")
@AllArgsConstructor
public class ViewClientCtrl {
    private ClientService clientService;

    @GetMapping("/display")
    public String clientDisplay(Model model){
        model.addAttribute("clients",clientService.getAllClients());
        return "clients-display";
    }
}

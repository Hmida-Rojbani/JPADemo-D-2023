package de.tekup.jpademo.controllers;

import de.tekup.jpademo.entities.ClientEntity;
import de.tekup.jpademo.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @GetMapping("/add")
    public String clientAdd(Model model){
       model.addAttribute("client",new ClientEntity());
        return "clients-add";
    }

    @PostMapping("/add")
    public String clientAddPost(@Valid @ModelAttribute("client") ClientEntity client,
                                BindingResult result){

        if(result.hasErrors()){
            return "clients-add";
        }
        clientService.insertIntoDB(client);
        return "redirect:/clients/ui/display";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") int clientId){
        clientService.deleteClient(clientId);
        return "redirect:/clients/ui/display";
    }

    @GetMapping("/update/{id}")
    public String updateClient(Model model,@PathVariable("id") int clientId){
        model.addAttribute("client",clientService.getClientById(clientId));
        return "clients-add";
    }
}

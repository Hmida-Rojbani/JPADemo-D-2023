package de.tekup.jpademo.controllers;

import de.tekup.jpademo.entities.ClientEntity;
import de.tekup.jpademo.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ClientCtrl {

    private ClientService clientService;
    //@RequestMapping(path="/clients/save",method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PostMapping("/clients/save")
    public ClientEntity saveClient(@RequestBody ClientEntity client){
        return clientService.insertIntoDB(client);
    }
    //@RequestMapping(path="/clients",method = RequestMethod.GET)
    @GetMapping("/clients")
    public List<ClientEntity> getAllClient(){
        return clientService.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public ClientEntity getClientById(@PathVariable("id") int clientId){
               return clientService.getClientById(clientId);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException e ){
        return e.getMessage();
    }

}

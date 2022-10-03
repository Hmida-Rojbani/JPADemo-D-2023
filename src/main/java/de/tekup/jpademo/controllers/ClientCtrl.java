package de.tekup.jpademo.controllers;

import de.tekup.jpademo.entities.ClientEntity;
import de.tekup.jpademo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientCtrl {
    @Autowired
    private ClientService clientService;
    //@RequestMapping(path="/clients/save",method = RequestMethod.POST)
    @PostMapping("/clients/save")
    @ResponseBody
    public ClientEntity saveClient(@RequestBody ClientEntity client){
        return clientService.insertIntoDB(client);
    }
    //@RequestMapping(path="/clients",method = RequestMethod.GET)
    @GetMapping("/clients")
    @ResponseBody
    public List<ClientEntity> getAllClient(){
        return clientService.getAllClients();
    }

    @GetMapping("/clients/{id}")
    @ResponseBody
    public ClientEntity getClientById(@PathVariable("id") int clientId){
               return clientService.getClientById(clientId);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgumentException(IllegalArgumentException e ){
        return e.getMessage();
    }

}

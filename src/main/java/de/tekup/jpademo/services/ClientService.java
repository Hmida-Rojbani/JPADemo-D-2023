package de.tekup.jpademo.services;

import de.tekup.jpademo.entities.ClientEntity;
import de.tekup.jpademo.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity insertIntoDB(ClientEntity client){
       return clientRepository.save(client);
    }

    public List<ClientEntity> getAllClients(){
       return (List<ClientEntity>) clientRepository.findAll();
    }
}

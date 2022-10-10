package de.tekup.jpademo.services;

import de.tekup.jpademo.entities.ClientEntity;
import de.tekup.jpademo.entities.LocationEntity;
import de.tekup.jpademo.repos.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    private LocationRepository locationRepository;
    private ClientService clientService;

    public LocationEntity saveLocation(LocationEntity location,int idClient){
        //search for client in DB
        ClientEntity client = clientService.getClientById(idClient);
        // add client to location object
        location.setClient(client);
        //save location in DB
        return locationRepository.save(location);

    }

}

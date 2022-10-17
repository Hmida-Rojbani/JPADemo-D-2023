package de.tekup.jpademo.services;

import de.tekup.jpademo.entities.ClientEntity;
import de.tekup.jpademo.entities.LocationEntity;
import de.tekup.jpademo.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ClientService clientService;

    public LocationEntity saveLocation(LocationEntity location,int idClient){
        //search for client in DB
        ClientEntity client = clientService.getClientById(idClient);
        // add client to location object
        location.setClient(client);
        //save location in DB
        return locationRepository.save(location);

    }

    public List<LocationEntity> getAllLocations(){
        return (List<LocationEntity>) locationRepository.findAll();
    }
}

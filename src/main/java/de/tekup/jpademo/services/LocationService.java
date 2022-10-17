package de.tekup.jpademo.services;

import de.tekup.jpademo.entities.ClientEntity;
import de.tekup.jpademo.entities.LocationEntity;
import de.tekup.jpademo.entities.VoitureEntity;
import de.tekup.jpademo.repos.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {

    private LocationRepository locationRepository;

    private ClientService clientService;
    private VoitureService voitureService;

    public LocationEntity saveLocation(LocationEntity location,int idClient,int idVoiture){
        //search for client in DB
        ClientEntity client = clientService.getClientById(idClient);
        //Search for voiture in DB
        VoitureEntity voiture = voitureService.getVoitureById(idVoiture);
        // add client and voiture to location object
        location.setClient(client);
        location.setVoiture(voiture);
        //save location in DB
        return locationRepository.save(location);

    }

    public List<LocationEntity> getAllLocations(){
        return (List<LocationEntity>) locationRepository.findAll();
    }
}

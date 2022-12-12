package de.tekup.jpademo.controllers;

import de.tekup.jpademo.entities.LocationEntity;
import de.tekup.jpademo.services.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LocationCtrl {

    private LocationService locationService;

    @PostMapping("/locations/add/client/{idClient}/voiture/{idVoiture}")
    public LocationEntity addLocation(@RequestBody LocationEntity location,
                              @PathVariable("idClient") int idClient, @PathVariable("idVoiture") int idVoiture){
        return locationService.saveLocation(location,idClient, idVoiture);
    }

    @GetMapping("/locations")
    public List<LocationEntity> getLocation(){
        return locationService.getAllLocations();
    }
}

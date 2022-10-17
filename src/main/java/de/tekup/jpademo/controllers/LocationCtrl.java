package de.tekup.jpademo.controllers;

import de.tekup.jpademo.entities.LocationEntity;
import de.tekup.jpademo.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocationCtrl {
    @Autowired
    private LocationService locationService;

    @PostMapping("/locations/add/client/{idClient}")
    @ResponseBody
    public LocationEntity addLocation(@RequestBody LocationEntity location,
                              @PathVariable("idClient") int idClient){
        return locationService.saveLocation(location,idClient);
    }

    @GetMapping("/locations")
    @ResponseBody
    public List<LocationEntity> getLocation(){
        return locationService.getAllLocations();
    }
}

package de.tekup.jpademo.controllers;

import de.tekup.jpademo.entities.LocationEntity;
import de.tekup.jpademo.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
}

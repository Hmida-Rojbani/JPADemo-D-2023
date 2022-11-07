package de.tekup.jpademo.controllers;

import de.tekup.jpademo.entities.VoitureEntity;
import de.tekup.jpademo.services.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class VoitureCtrl {

    private VoitureService voitureService;
    //@RequestMapping(path="/clients/save",method = RequestMethod.POST)
    @PostMapping("/voitures/save")
    @ResponseBody
    public VoitureEntity saveVoiture(@RequestBody VoitureEntity voiture){
        return voitureService.insertIntoDB(voiture);
    }
    //@RequestMapping(path="/clients",method = RequestMethod.GET)
    @GetMapping("/voitures")
    @ResponseBody
    public List<VoitureEntity> getAllVoitures(){
        return voitureService.getAllVoitures();
    }

    @GetMapping("/voitures/{id}")
    @ResponseBody
    public VoitureEntity getVoitureById(@PathVariable("id") int voitureId){
        return voitureService.getVoitureById(voitureId);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgumentException(IllegalArgumentException e ){
        return e.getMessage();
    }
}

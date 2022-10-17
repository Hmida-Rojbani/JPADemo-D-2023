package de.tekup.jpademo.services;

import de.tekup.jpademo.entities.VoitureEntity;
import de.tekup.jpademo.repos.VoitureRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VoitureService {

    
    private VoitureRepository voitureRepository;
    
   

    public VoitureEntity insertIntoDB(VoitureEntity voiture){
        return voitureRepository.save(voiture);
    }

    public List<VoitureEntity> getAllVoitures(){
        return (List<VoitureEntity>) voitureRepository.findAll();
    }

    public VoitureEntity getVoitureById(int id){
        return voitureRepository
                .findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Voiture ID not Found"));
    }
}

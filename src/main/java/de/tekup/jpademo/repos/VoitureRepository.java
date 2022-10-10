package de.tekup.jpademo.repos;

import de.tekup.jpademo.entities.VoitureEntity;
import org.springframework.data.repository.CrudRepository;

public interface VoitureRepository extends CrudRepository<VoitureEntity,Integer> {
}

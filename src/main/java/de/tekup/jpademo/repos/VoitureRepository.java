package de.tekup.jpademo.repos;

import de.tekup.jpademo.entities.VoitureEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VoitureRepository extends PagingAndSortingRepository<VoitureEntity,Integer> {
}
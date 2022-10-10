package de.tekup.jpademo.repos;

import de.tekup.jpademo.entities.LocationEntity;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<LocationEntity, Integer> {
}

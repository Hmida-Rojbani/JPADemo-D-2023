package de.tekup.jpademo.repos;

import de.tekup.jpademo.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity,Integer> {
}

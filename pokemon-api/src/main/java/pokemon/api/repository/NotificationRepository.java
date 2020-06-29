package pokemon.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pokemon.api.entity.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Integer>{

}

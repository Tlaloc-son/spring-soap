package pokemon.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pokemon.api.entity.Log;

@Repository
public interface LogRepository extends CrudRepository<Log, Integer>{

}

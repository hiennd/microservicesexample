package example.repository;

import example.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Duc Hien Nguyen
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
}

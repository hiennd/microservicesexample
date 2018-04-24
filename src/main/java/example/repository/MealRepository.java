package example.repository;

import example.domain.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Duc Hien Nguyen
 */
@Repository
public interface MealRepository extends CrudRepository<Meal, Long>{
}

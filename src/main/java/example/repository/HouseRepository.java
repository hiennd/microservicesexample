package example.repository;

import example.domain.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Duc Hien Nguyen
 */
@Repository
public interface HouseRepository extends CrudRepository<House, Long> {
    Optional<House> findByOwnerId(Long ownerId);
}

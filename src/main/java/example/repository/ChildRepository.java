package example.repository;

import example.domain.Child;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Duc Hien Nguyen
 */
@Repository
public interface ChildRepository extends PagingAndSortingRepository<Child, Long> {
}

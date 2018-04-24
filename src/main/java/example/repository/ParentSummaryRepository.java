package example.repository;

import example.domain.ParentSummary;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Duc Hien Nguyen
 */
@Repository
public interface ParentSummaryRepository extends PagingAndSortingRepository<ParentSummary, Long> {
}

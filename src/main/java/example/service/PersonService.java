package example.service;

import example.config.CacheName;
import example.repository.PersonRepository;
import example.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Duc Hien Nguyen
 */
@Service
public class PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }


    @Cacheable(cacheManager = "cacheManager", cacheNames = CacheName.CACHE_PERSON_BY_ID)
    public Optional<Person> findById(Long parentId) {
        return Optional.ofNullable(repository.findOne(parentId));
    }
}

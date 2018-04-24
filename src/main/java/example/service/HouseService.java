package example.service;

import example.dto.ApiResponse;
import example.repository.HouseRepository;
import example.domain.House;
import example.exceptions.HouseNotFoundException;
import example.config.CacheName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Duc Hien Nguyen
 */
@Service
public class HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Cacheable(cacheManager = "cacheManager", cacheNames = CacheName.CACHE_HOUSE_BY_OWNER_ID)
    public ApiResponse<House> getHouseByOwnerId(Long ownerId) {
        Optional<House> house = houseRepository.findByOwnerId(ownerId);
        if (!house.isPresent()) {
            throw new HouseNotFoundException("Not found by ownerId: "+ownerId);
        }
        return new ApiResponse<>(house.get());
    }
}

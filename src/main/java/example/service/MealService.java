package example.service;

import example.domain.Meal;
import example.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Duc Hien Nguyen
 */
@Service
public class MealService {

    private final MealRepository mealRepository;

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    Optional<Meal> findById(Long mealId) {
        return Optional.ofNullable(mealRepository.findOne(mealId));
    }
}

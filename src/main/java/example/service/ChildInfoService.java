package example.service;

import example.domain.Child;
import example.domain.Daughter;
import example.domain.Gender;
import example.domain.Meal;
import example.domain.Person;
import example.domain.Son;
import net.fobic.domain.*;
import example.dto.ApiResponse;
import example.dto.ChildInfo;
import example.exceptions.ChildNotFoundException;
import example.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Duc Hien Nguyen
 */
@Service
public class ChildInfoService {

    private final ChildRepository childRepository;

    private final PersonService personService;

    private final MealService mealService;

    @Autowired
    public ChildInfoService(ChildRepository childRepository, PersonService personService, MealService mealService) {
        this.childRepository = childRepository;
        this.personService = personService;
        this.mealService = mealService;
    }

    public ApiResponse<ChildInfo> getChildInfo(Long childId) {
        ChildInfo childInfo = new ChildInfo();

        Optional<Child> childOptional = Optional.ofNullable(childRepository.findOne(childId));
        Child child = childOptional.orElseThrow(()->new ChildNotFoundException(childId));


        Optional<Person> personOptional = personService.findById(child.getParentId());
        personOptional.ifPresent(childInfo::setPerson);

        if (!child.getMeals().isEmpty()) {
            Optional<Meal> favouriteMealOptional = mealService.findById(child.getMeals().get(0));
            favouriteMealOptional.ifPresent(childInfo::setFavouriteMeal);
        }
        return new ApiResponse<>(childInfo);
    }

    public ApiResponse<String> getColor(Long childId) {

        Optional<Child> childOptional = Optional.ofNullable(childRepository.findOne(childId));
        Child child = childOptional.orElseThrow(()->new ChildNotFoundException(childId));

        if (Gender.BOY.equalsIgnoreCase(child.getGender())) {
            return new ApiResponse<>(((Son)child).getBicycleColor());
        }
        if (Gender.GIRL.equalsIgnoreCase(child.getGender())){
            return new ApiResponse<>(((Daughter)child).getHairColor());
        }
        return new ApiResponse<>("");
    }
}

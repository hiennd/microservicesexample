package example.dto;

import example.domain.Meal;
import example.domain.Person;
import lombok.Data;

/**
 * @author Duc Hien Nguyen
 */
@Data
public class ChildInfo {
    private Person person;
    private Meal favouriteMeal;
}

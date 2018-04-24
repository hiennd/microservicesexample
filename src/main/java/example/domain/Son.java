package example.domain;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Duc Hien Nguyen
 */
@Data
@Entity
@Table(name = "son")
@DiscriminatorValue(Gender.BOY)
public class Son extends Child {
    private String bicycleColor;
}

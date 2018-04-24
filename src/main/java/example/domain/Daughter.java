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
@Table(name = "daughter")
@DiscriminatorValue(Gender.GIRL)
public class Daughter extends Child {
    private String hairColor;
}

package example.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Duc Hien Nguyen
 */
@Data
@Entity
@Table(name = "parentSummary")
public class ParentSummary {

    @Id
    private Long id;
    private Long amountOfPersons;
    private Long amountOfChildren;

    public ParentSummary(Long amountOfPersons, Long amountOfChildren) {
        this.amountOfChildren = amountOfChildren;
        this.amountOfPersons = amountOfPersons;
    }
}

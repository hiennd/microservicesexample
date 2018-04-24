package example.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

/**
 * @author Duc Hien Nguyen
 */
@Data
@Entity
@Table(name = "person")
@Inheritance(
        strategy = InheritanceType.SINGLE_TABLE
)
@DiscriminatorColumn(name = "gender")
public class Child {

    @Id
    private Long id;
    private String name;
    private int age;

    @NotBlank(message = "Parent is required")
    private Long parentId;

    @OneToMany(targetEntity=Meal.class, mappedBy="id", fetch=FetchType.LAZY)
    private List<Long> meals;

    @Column(name = "gender", insertable = false, updatable = false)
    private String gender;
}

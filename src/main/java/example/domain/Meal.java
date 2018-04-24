package example.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

/**
 * @author Duc Hien Nguyen
 */
@Data
@Entity
@Table(name = "meal")
public class Meal {
    @Id
    private Long id;

    private String name;
    private Instant invented;
}

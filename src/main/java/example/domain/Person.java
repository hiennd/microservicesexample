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
@Table(name = "person")
public class Person {
    @Id
    private Long id;
    private String name;
    private int age;
}

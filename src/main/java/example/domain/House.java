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
@Table(name = "house")
public class House {
    @Id
    private Long houseId;
    private String address;
    private String zipCode;
    private HouseType houseType;

    private Long ownerId;
}

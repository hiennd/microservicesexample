package example.exceptions;

/**
 * @author Duc Hien Nguyen
 */
public class HouseNotFoundException extends RuntimeException {
    public HouseNotFoundException(String mesage) {
        super(mesage);
    }
}

package example.exceptions;

/**
 * @author Duc Hien Nguyen
 */
public class ChildNotFoundException extends RuntimeException {

    public ChildNotFoundException(Long childId) {
        super("Child not found by id: "+childId);
    }
}

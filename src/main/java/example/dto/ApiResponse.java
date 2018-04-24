package example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author Duc Hien Nguyen
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ApiResponse<T> {

    private HttpStatus status;
    private String message;
    private T payload;

    public ApiResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ApiResponse(T payload) {
        this.payload = payload;
        status = HttpStatus.OK;
    }
}

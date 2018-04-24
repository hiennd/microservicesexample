package example.controller;

import example.dto.ApiResponse;
import example.exceptions.ChildNotFoundException;
import example.exceptions.HouseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Duc Hien Nguyen
 */
@ControllerAdvice
@ResponseBody
public class FullHouseControllerAdvice {

    @ExceptionHandler(ChildNotFoundException.class)
    public ApiResponse handleChildNotFound(ChildNotFoundException e) {
        return new ApiResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(HouseNotFoundException.class)
    public ApiResponse handleChildNotFound(HouseNotFoundException e) {
        return new ApiResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }
}

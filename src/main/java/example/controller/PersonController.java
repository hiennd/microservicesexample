package example.controller;

import example.service.ParentSummaryService;
import example.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Duc Hien Nguyen
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final ParentSummaryService service;

    @Autowired
    public PersonController(ParentSummaryService service) {
        this.service = service;
    }

    @GetMapping("/children")
    public ApiResponse<List<Long>> getChildInfo() {
        return service.getAmountOfParentsWhoHaveNChildren();
    }
}

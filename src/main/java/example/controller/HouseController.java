package example.controller;

import example.dto.ApiResponse;
import example.service.HouseService;
import example.domain.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Duc Hien Nguyen
 */
@RestController
@RequestMapping("/house")
public class HouseController {

    private final HouseService service;

    @Autowired
    public HouseController(HouseService service) {
        this.service = service;
    }

    @GetMapping
    public ApiResponse<House> getHouseByOwnerId(@RequestParam Long ownerId){
        return service.getHouseByOwnerId(ownerId);
    }
}

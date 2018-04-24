package example.controller;

import example.dto.ApiResponse;
import example.service.ChildInfoService;
import example.dto.ChildInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Duc Hien Nguyen
 */
@RestController
@RequestMapping("/child")
public class ChildInfoController {

    private final ChildInfoService service;

    @Autowired
    public ChildInfoController(ChildInfoService service) {
        this.service = service;
    }

    @GetMapping("/info")
    public ApiResponse<ChildInfo> getChildInfo(Long childId) {
        return service.getChildInfo(childId);
    }
    @GetMapping("/color")
    public ApiResponse<String> getColor(Long childId) {
        return service.getColor(childId);
    }
}

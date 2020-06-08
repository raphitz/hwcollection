package com.hwc.server.controller;

import com.hwc.server.component.SecurityHelper;
import com.hwc.server.model.CarCollection;
import com.hwc.server.service.CarCollectionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/collection")
@AllArgsConstructor
public class CarCollectionController {

    private final CarCollectionService service;
    private final SecurityHelper securityHelper;

    @PostMapping("/{carId}")
    public CarCollection addToCollection(@PathVariable String carId) {
        return service.addToCollection(securityHelper.getUserId(), carId).orElse(null);
    }

    @DeleteMapping("/{carId}")
    public void removeFromCollection(@PathVariable String carId) {
        service.removeFromCollection(securityHelper.getUserId(), carId);
    }

    @GetMapping("/{userId}")
    public Page<CarCollection> findAllByUserId(@PathVariable String userId,
                                               @RequestParam("page") int page,
                                               @RequestParam("size") int size) {
        return service.findAllByUserId(userId, page, size);
    }

}

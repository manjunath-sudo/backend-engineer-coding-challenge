package com.demo.hotel.allocation.controller;

import com.demo.hotel.allocation.model.OccupancyRequest;
import com.demo.hotel.allocation.model.OccupancyResponse;
import com.demo.hotel.allocation.service.OccupancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/occupancy")
public class OccupancyController {

    @Autowired
    private OccupancyService service;

    @PostMapping
    public OccupancyResponse calculateOccupancy(@RequestBody OccupancyRequest request) {
        return service.allocateSeat(request);
    }
}

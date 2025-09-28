package com.demo.hotel.allocation.controller;

import com.demo.hotel.allocation.model.OccupancyRequest;
import com.demo.hotel.allocation.model.OccupancyResponse;
import com.demo.hotel.allocation.service.OccupancyService;
import com.demo.hotel.allocation.service.OccupancyServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/occupancy")
public class OccupancyController {

    private final OccupancyService occupancyService;

    public OccupancyController(OccupancyService service){
        this.occupancyService=service;
    }

    @PostMapping
    public OccupancyResponse calculateOccupancy(@RequestBody(required = true) OccupancyRequest request) {
        return occupancyService.allocateSeat(request);
    }
}

package com.example.hotelallocation.controller;

import com.example.hotelallocation.model.OccupancyRequest;
import com.example.hotelallocation.model.OccupancyResponse;
import com.example.hotelallocation.service.OccupancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/occupancy")
public class OccupancyController {

    @Autowired
    private OccupancyService service;

    @PostMapping
    public OccupancyResponse calculateOccupancy(@RequestBody OccupancyRequest request) {
        return service.allocate(request);
    }
}

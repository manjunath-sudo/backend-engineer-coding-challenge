package com.demo.hotel.allocation.controller;

import com.demo.hotel.allocation.model.OccupancyRequest;
import com.demo.hotel.allocation.model.OccupancyResponse;
import com.demo.hotel.allocation.service.OccupancyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/occupancy")
public class OccupancyController {

    private final OccupancyService occupancyService;

    public OccupancyController(OccupancyService service) {
        this.occupancyService = service;
    }

    @Operation(summary = "Allocate hotel rooms based on guest payments")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful allocation"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PostMapping
    public OccupancyResponse calculateOccupancy(@RequestBody(required = true) OccupancyRequest request) {
        return occupancyService.allocateSeat(request);
    }
}

package com.demo.hotel.allocation.service;

import com.demo.hotel.allocation.model.OccupancyRequest;
import com.demo.hotel.allocation.model.OccupancyResponse;


public interface OccupancyService {
     OccupancyResponse allocateSeat(OccupancyRequest request);
}

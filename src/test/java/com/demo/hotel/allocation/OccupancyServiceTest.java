package com.demo.hotel.allocation;

import com.demo.hotel.allocation.model.OccupancyRequest;
import com.demo.hotel.allocation.model.OccupancyResponse;
import com.demo.hotel.allocation.service.OccupancyService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OccupancyServiceTest {

    private final OccupancyService service = new OccupancyService();

    @Test
    void testScenario1() {
        OccupancyRequest request = new OccupancyRequest();
        request.setPremiumRooms(3);
        request.setEconomyRooms(3);
        request.setPotentialGuests(Arrays.asList(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0));
        OccupancyResponse response = service.allocateSeat(request);
        assertEquals(3, response.usagePremium());
        assertEquals(738, (int) response.revenuePremium());
        assertEquals(3, response.usageEconomy());
        assertEquals(167.99, response.revenueEconomy(), 0.01);
    }

    @Test
    void testScenario2() {
        OccupancyRequest request = new OccupancyRequest();
        request.setPremiumRooms(7);
        request.setEconomyRooms(5);
        request.setPotentialGuests(Arrays.asList(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0));
        OccupancyResponse response = service.allocateSeat(request);
        assertEquals(6, response.usagePremium());
        assertEquals(1054, (int) response.revenuePremium());
        assertEquals(4, response.usageEconomy());
        assertEquals(189.99, response.revenueEconomy(), 0.01);
    }

    @Test
    void testScenario3() {
        OccupancyRequest request = new OccupancyRequest();
        request.setPremiumRooms(2);
        request.setEconomyRooms(7);
        request.setPotentialGuests(Arrays.asList(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0));
        OccupancyResponse response = service.allocateSeat(request);
        assertEquals(2, response.usagePremium());
        assertEquals(583, (int) response.revenuePremium());
        assertEquals(4, response.usageEconomy());
        assertEquals(189.99, response.revenueEconomy(), 0.01);
    }
}

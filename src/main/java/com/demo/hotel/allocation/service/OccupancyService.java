package com.demo.hotel.allocation.service;

import com.demo.hotel.allocation.model.OccupancyRequest;
import com.demo.hotel.allocation.model.OccupancyResponse;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OccupancyService {

    public OccupancyResponse allocateSeat(OccupancyRequest request) {
        List<Double> sortedGuests = request.getPotentialGuests().stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        int premiumRooms = request.getPremiumRooms();
        int economyRooms = request.getEconomyRooms();

        double revenuePremium = 0;
        double revenueEconomy = 0;
        int usagePremium = 0;
        int usageEconomy = 0;

        List<Double> premiumGuests = sortedGuests.stream().filter(g -> g >= 100).toList();
        List<Double> economyGuests = sortedGuests.stream().filter(g -> g < 100).toList();

        for (Double guest : premiumGuests) {
            if (usagePremium < premiumRooms) {
                usagePremium++;
                revenuePremium += guest;
            }
        }

        for (Double guest : economyGuests) {
            if (usageEconomy < economyRooms) {
                usageEconomy++;
                revenueEconomy += guest;
            } else if (usagePremium < premiumRooms) {
                usagePremium++;
                revenuePremium += guest;
            }
        }

        return new OccupancyResponse(usagePremium, revenuePremium, usageEconomy, revenueEconomy);
    }
}

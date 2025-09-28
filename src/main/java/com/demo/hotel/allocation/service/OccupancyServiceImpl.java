package com.demo.hotel.allocation.service;

import com.demo.hotel.allocation.model.OccupancyRequest;
import com.demo.hotel.allocation.model.OccupancyResponse;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OccupancyServiceImpl implements OccupancyService {

    private static final int PREDICATE = 100;
    private static final int INDEX_ZERO = 0;

    @Override
    public OccupancyResponse allocateSeat(OccupancyRequest request) {
        List<Double> sortedGuests = sortGuestsDescending(request.getPotentialGuests());

        Map<Boolean, List<Double>> partitionedGuests = partitionGuests(sortedGuests);

        List<Double> allocatedPremium = allocatePremiumRooms(partitionedGuests.get(true), request.getPremiumRooms());
        List<Double> allocatedEconomy = allocateEconomyRooms(partitionedGuests.get(false), request.getEconomyRooms());

        List<Double> upgradedGuests = upgradeEconomyGuests(partitionedGuests.get(false), allocatedEconomy.size(),
                request.getPremiumRooms() - allocatedPremium.size());
        return buildResponse(allocatedPremium, allocatedEconomy, upgradedGuests);
    }

    private List<Double> sortGuestsDescending(List<Double> guests) {
        return guests.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    private Map<Boolean, List<Double>> partitionGuests(List<Double> sortedGuests) {
        return sortedGuests.stream()
                .collect(Collectors.partitioningBy(g -> g >= PREDICATE));
    }

    private List<Double> allocatePremiumRooms(List<Double> premiumGuests, int premiumRooms) {
        return premiumGuests.stream()
                .limit(premiumRooms)
                .toList();
    }

    private List<Double> allocateEconomyRooms(List<Double> economyGuests, int economyRooms) {
        return economyGuests.stream()
                .limit(economyRooms)
                .toList();
    }

    private List<Double> upgradeEconomyGuests(List<Double> economyGuests, int allocatedEconomyCount, int remainingPremiumRooms) {
        return economyGuests.stream()
                .skip(allocatedEconomyCount)
                .limit(Math.max(remainingPremiumRooms, INDEX_ZERO))
                .toList();
    }

    private OccupancyResponse buildResponse(List<Double> allocatedPremium, List<Double> allocatedEconomy, List<Double> upgradedGuests) {
        int usagePremium = allocatedPremium.size() + upgradedGuests.size();
        double revenuePremium = sumList(allocatedPremium) + sumList(upgradedGuests);

        int usageEconomy = allocatedEconomy.size();
        double revenueEconomy = sumList(allocatedEconomy);
        return new OccupancyResponse(usagePremium, (int) Math.floor(revenuePremium), usageEconomy, revenueEconomy);
    }

    private double sumList(List<Double> list) {
        return list.stream().mapToDouble(Double::doubleValue).sum();
    }

}


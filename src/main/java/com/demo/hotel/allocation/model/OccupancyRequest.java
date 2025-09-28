package com.demo.hotel.allocation.model;

import java.util.List;

public class OccupancyRequest {
    private int premiumRooms;
    private int economyRooms;
    private List<Double> potentialGuests;

    public int getPremiumRooms() { return premiumRooms; }
    public void setPremiumRooms(int premiumRooms) { this.premiumRooms = premiumRooms; }

    public int getEconomyRooms() { return economyRooms; }
    public void setEconomyRooms(int economyRooms) { this.economyRooms = economyRooms; }

    public List<Double> getPotentialGuests() { return potentialGuests; }
    public void setPotentialGuests(List<Double> potentialGuests) { this.potentialGuests = potentialGuests; }
}

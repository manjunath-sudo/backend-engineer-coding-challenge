package com.example.hotelallocation.model;

public class OccupancyResponse {
    private int usagePremium;
    private double revenuePremium;
    private int usageEconomy;
    private double revenueEconomy;

    public OccupancyResponse(int usagePremium, double revenuePremium, int usageEconomy, double revenueEconomy) {
        this.usagePremium = usagePremium;
        this.revenuePremium = revenuePremium;
        this.usageEconomy = usageEconomy;
        this.revenueEconomy = revenueEconomy;
    }

    public int getUsagePremium() { return usagePremium; }
    public double getRevenuePremium() { return revenuePremium; }
    public int getUsageEconomy() { return usageEconomy; }
    public double getRevenueEconomy() { return revenueEconomy; }
}

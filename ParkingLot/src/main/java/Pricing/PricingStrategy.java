package Pricing;

import ParkingLot.Ticket;

public interface PricingStrategy {
    double totalCost(Ticket ticket);
}

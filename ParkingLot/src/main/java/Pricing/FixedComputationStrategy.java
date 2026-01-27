package Pricing;

import ParkingLot.Ticket;

public class FixedComputationStrategy implements PricingStrategy{

    @Override
    public double totalCost(Ticket ticket){
        return 10;
    }
}

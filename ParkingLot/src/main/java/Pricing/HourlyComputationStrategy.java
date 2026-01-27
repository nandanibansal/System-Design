package Pricing;

import java.time.LocalDateTime;
import ParkingLot.Ticket;

public class HourlyComputationStrategy implements PricingStrategy{

    @Override
    public double totalCost(Ticket ticket) {
        long hourEntry = ticket.getEntryTime().getHour();
        long hourExit = LocalDateTime.now().getHour();
        return (hourEntry-hourExit) * 5;
    }
}

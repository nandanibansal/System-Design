package ParkingLot;

import Payment.Payment;
import Pricing.CostComputation;
import entity.Vehicle;

public class ExitGate {
    private final CostComputation costComputation;

    public ExitGate(CostComputation costComputation) {
        this.costComputation = costComputation;
    }

    public void exit(ParkingBuilding parkingBuilding, Ticket ticket, Payment payment){
        double amount = costComputation.compute(ticket);
        boolean success = payment.pay(amount);
        if(!success) throw new RuntimeException("Payment unsuccessful");
        parkingBuilding.release(ticket);
        System.out.println("Exit successful. Gate opened.");
    }
}

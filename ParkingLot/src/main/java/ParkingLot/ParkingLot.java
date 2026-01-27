package ParkingLot;

import Payment.Payment;
import entity.ParkingSpot;
import entity.Vehicle;

public class ParkingLot {
    private final ParkingBuilding parkingBuilding;
    private final EntryGate entryGate;
    private final ExitGate exitGate;

    public ParkingLot(ParkingBuilding parkingBuilding, EntryGate entryGate, ExitGate exitGate) {
        this.parkingBuilding = parkingBuilding;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
    }

    public Ticket vehicleArrives(Vehicle vehicle){
        return entryGate.enter(parkingBuilding, vehicle);
    }

    public void vehicleLeft(Ticket ticket, Payment payment){
        exitGate.exit(parkingBuilding, ticket, payment);
    }
}

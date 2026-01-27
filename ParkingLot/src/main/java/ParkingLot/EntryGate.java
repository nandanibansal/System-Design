package ParkingLot;

import entity.Vehicle;

public class EntryGate {
    public Ticket enter(ParkingBuilding parkingBuilding, Vehicle vehicle){
        return parkingBuilding.allocate(vehicle);
    }
}

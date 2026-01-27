package ParkingLot;

import entity.ParkingSpot;
import entity.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final ParkingLevel parkingLevel;
    private final LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, ParkingLevel parkingLevel, ParkingSpot spot)
    {
        this.vehicle = vehicle;
        this.parkingSpot = spot;
        this.parkingLevel = parkingLevel;
        this.entryTime = LocalDateTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingLevel getLevel() {
        return parkingLevel;
    }

    public ParkingSpot getSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

}

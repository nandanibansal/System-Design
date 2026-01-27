package ParkingLot;

import Pricing.CostComputation;
import entity.ParkingSpot;
import entity.Vehicle;

import java.time.LocalDateTime;
import java.util.List;

public class ParkingBuilding {
    private final List<ParkingLevel> parkingLevelList;

    public ParkingBuilding(List<ParkingLevel> parkingLevelList, CostComputation costComputation){
        this.parkingLevelList = parkingLevelList;
    }

    Ticket allocate(Vehicle vehicle){
        for(ParkingLevel parkingLevel: parkingLevelList){
            if(parkingLevel.hasAvailability(vehicle.getVehicleType())){
                ParkingSpot spot = parkingLevel.park(vehicle.getVehicleType());
                if(spot!=null) {
                    System.out.println("Parking allocated at level: "
                            + parkingLevel.getLevelNumber()
                            + " spot: " + spot.getSpotId());
                    return new Ticket(vehicle, parkingLevel, spot);
                }
            }
        }
        throw new RuntimeException("Parking full");
    }

    void release(Ticket ticket){
        ticket.getLevel().unPark(ticket.getVehicle().getVehicleType(), ticket.getSpot());
    }
}

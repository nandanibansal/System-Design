package spotManagers;

import LookUpStrategy.ParkingSpotStrategy;
import entity.ParkingSpot;

import java.util.List;

public class EVSpotManager extends ParkingSpotManager{
    public EVSpotManager(List<ParkingSpot> spots, ParkingSpotStrategy strategy) {
        super(spots, strategy);
    }
}

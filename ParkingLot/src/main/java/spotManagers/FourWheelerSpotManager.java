package spotManagers;

import LookUpStrategy.ParkingSpotStrategy;
import entity.ParkingSpot;

import java.util.List;

public class FourWheelerSpotManager extends ParkingSpotManager{
    public FourWheelerSpotManager(List<ParkingSpot> spots, ParkingSpotStrategy strategy) {
        super(spots, strategy);
    }
}

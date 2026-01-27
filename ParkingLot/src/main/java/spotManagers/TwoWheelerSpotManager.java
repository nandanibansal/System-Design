package spotManagers;

import LookUpStrategy.ParkingSpotStrategy;
import entity.ParkingSpot;

import java.util.List;

public class TwoWheelerSpotManager extends ParkingSpotManager{

    public TwoWheelerSpotManager(List<ParkingSpot> spots, ParkingSpotStrategy strategy) {
        super(spots, strategy);
    }
}

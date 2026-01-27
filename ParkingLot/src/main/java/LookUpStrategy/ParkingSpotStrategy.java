package LookUpStrategy;

import entity.ParkingSpot;

import java.util.List;

public interface ParkingSpotStrategy {
    ParkingSpot selectParkingSpot(List<ParkingSpot> spotList);
}

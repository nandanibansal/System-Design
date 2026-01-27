package LookUpStrategy;

import entity.ParkingSpot;

import java.util.List;

public class RandomLookUpStrategy implements ParkingSpotStrategy{
    List<ParkingSpot> spotList;

    @Override
    public ParkingSpot selectParkingSpot(List<ParkingSpot> spotList){
        for(ParkingSpot spot: spotList){
            if(spot.isSpotFree()){
                return spot;
            }
        }
        return null;
    }
}

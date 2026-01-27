package entity;

public class ParkingSpot {
    private final String spotId;
    private boolean isSpotFree = true;

    public ParkingSpot(String spotId){
        this.spotId = spotId;
    }

    public void occupySpot(){
        isSpotFree = false;
    }

    public void releaseSpot(){
        isSpotFree = true;
    }

    public boolean isSpotFree(){
        return isSpotFree;
    }

    public String getSpotId(){
        return spotId;
    }
}

package spotManagers;

import LookUpStrategy.ParkingSpotStrategy;
import entity.ParkingSpot;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingSpotManager {
    protected final List<ParkingSpot> spots;
    protected final ParkingSpotStrategy strategy;
    private final ReentrantLock lock = new ReentrantLock(true);

    public ParkingSpotManager(List<ParkingSpot> spots, ParkingSpotStrategy strategy) {
        this.spots = spots;
        this.strategy = strategy;
    }

    public ParkingSpot park(){
        lock.lock();
        try {
            ParkingSpot spot = strategy.selectParkingSpot(spots);
            if (spot == null) {
                return null;
            }
            spot.occupySpot();
            return spot;
        }
        finally {
            lock.unlock();
        }
    }

    public void unPark(ParkingSpot spot){
        lock.lock();
        try {
            spot.releaseSpot();
        }
        finally {
            lock.unlock();
        }
    }

    public boolean hasFreeSpot(){
        lock.lock();
        try {
            return spots.stream().anyMatch(ParkingSpot::isSpotFree);
        }
        finally {
            lock.unlock();
        }
    }
}

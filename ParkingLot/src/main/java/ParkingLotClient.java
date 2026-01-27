import LookUpStrategy.*;
import ParkingLot.*;
import Payment.CashPayment;
import Payment.UPIPayment;
import Pricing.*;
import entity.*;
import enums.VehicleType;
import spotManagers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotClient {
    public static void main(String[] args) {
        ParkingSpotStrategy parkingSpotStrategy = new RandomLookUpStrategy();

        Map<VehicleType, ParkingSpotManager> levelOneManagers = new HashMap<>();
        levelOneManagers.put(VehicleType.TWO_WHEELER, new TwoWheelerSpotManager(List.of(new ParkingSpot("L1-1"), new ParkingSpot("L1-3")), parkingSpotStrategy));
        levelOneManagers.put(VehicleType.EV, new EVSpotManager(List.of(new ParkingSpot("L1-2"), new ParkingSpot("L1-4")), parkingSpotStrategy));
        levelOneManagers.put(VehicleType.FOUR_WHEELER, new FourWheelerSpotManager(List.of(new ParkingSpot("L1-5"), new ParkingSpot("L1-5")), parkingSpotStrategy));

        ParkingLevel level1 = new ParkingLevel(1, levelOneManagers);

        Map<VehicleType, ParkingSpotManager> levelTwoManagers = new HashMap<>();
        levelOneManagers.put(VehicleType.TWO_WHEELER, new TwoWheelerSpotManager(List.of(new ParkingSpot("L2-1"), new ParkingSpot("L2-3")), parkingSpotStrategy));
        levelOneManagers.put(VehicleType.EV, new EVSpotManager(List.of(new ParkingSpot("L2-2"), new ParkingSpot("L2-4")), parkingSpotStrategy));
        levelOneManagers.put(VehicleType.FOUR_WHEELER, new FourWheelerSpotManager(List.of(new ParkingSpot("L2-5"), new ParkingSpot("L2-5")), parkingSpotStrategy));

        ParkingLevel level2 = new ParkingLevel(1, levelTwoManagers);

        ParkingBuilding parkingBuilding = new ParkingBuilding(List.of(level1,level2), new CostComputation(new FixedComputationStrategy()));
        ParkingLot parkingLot = new ParkingLot(parkingBuilding, new EntryGate(), new ExitGate(new CostComputation(new FixedComputationStrategy())));

        Vehicle bike = new Vehicle("BIKE-101", VehicleType.TWO_WHEELER);
        Vehicle car = new Vehicle("CAR-101", VehicleType.FOUR_WHEELER);
        Vehicle scooter = new Vehicle("SCOOTER-101", VehicleType.EV);

        Ticket t1 = parkingLot.vehicleArrives(bike);
        Ticket t2 = parkingLot.vehicleArrives(bike);
        parkingLot.vehicleLeft(t2, new UPIPayment());
        Ticket t3 = parkingLot.vehicleArrives(bike);
        Ticket t4 = parkingLot.vehicleArrives(car);

        parkingLot.vehicleLeft(t1, new CashPayment());
        parkingLot.vehicleLeft(t4, new UPIPayment());
        parkingLot.vehicleLeft(t3, new UPIPayment());
    }
}
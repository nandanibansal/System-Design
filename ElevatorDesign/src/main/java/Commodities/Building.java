package Commodities;

import ElevatorOperation.ExternalDispatcher;

import java.util.ArrayList;
import java.util.List;

public class Building {
    List<Floor> floors = new ArrayList<>();

    public Building(int totalFloors, ExternalDispatcher externalDispatcher){
        for(int i=1;i<=totalFloors;i++){
            floors.add(new Floor(i, externalDispatcher));
        }
    }

    public Floor getFloor(int floorNumber) {
        return floors.get(floorNumber - 1);
    }

}

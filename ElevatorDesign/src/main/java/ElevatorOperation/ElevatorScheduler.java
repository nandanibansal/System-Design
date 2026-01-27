package ElevatorOperation;

import ElevatorStrategy.ElevatorSelectStrategy;
import Enums.ElevatorDirection;

import java.util.List;

public class ElevatorScheduler {
    private final List<ElevatorController> elevatorControllerList;
    private ElevatorSelectStrategy elevatorSelectStrategy;

    public ElevatorScheduler(List<ElevatorController> elevatorControllerList, ElevatorSelectStrategy elevatorSelectStrategy) {
        this.elevatorControllerList = elevatorControllerList;
        this.elevatorSelectStrategy = elevatorSelectStrategy;
    }

    public void setElevatorSelectStrategy(ElevatorSelectStrategy elevatorSelectStrategy) {
        this.elevatorSelectStrategy = elevatorSelectStrategy;
    }

    public ElevatorController assignElevator(int floor, ElevatorDirection elevatorDirection){
        return elevatorSelectStrategy.selectElevator(elevatorControllerList, floor, elevatorDirection);
    }
}

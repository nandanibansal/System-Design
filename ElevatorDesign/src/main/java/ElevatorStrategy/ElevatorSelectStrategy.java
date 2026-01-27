package ElevatorStrategy;

import ElevatorOperation.ElevatorController;
import Enums.ElevatorDirection;

import java.util.List;

public interface ElevatorSelectStrategy {
    ElevatorController selectElevator(List<ElevatorController> elevatorControllerList, int requestFloor, ElevatorDirection direction);
}

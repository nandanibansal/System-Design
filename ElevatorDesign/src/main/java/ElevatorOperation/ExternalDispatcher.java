package ElevatorOperation;

import Enums.ElevatorDirection;

public class ExternalDispatcher {
    ElevatorScheduler elevatorScheduler;

    public ExternalDispatcher(ElevatorScheduler elevatorScheduler) {
        this.elevatorScheduler = elevatorScheduler;
    }

    public void submitExternalRequest(int floor, ElevatorDirection direction) {
        ElevatorController elevatorController = elevatorScheduler.assignElevator(floor, direction);
        elevatorController.submitRequest(floor);
    }
}

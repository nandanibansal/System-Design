package ElevatorStrategy;

import ElevatorOperation.ElevatorController;
import Enums.ElevatorDirection;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorSelectStrategy {

    @Override
    public ElevatorController selectElevator(List<ElevatorController> elevatorControllerList, int requestFloor, ElevatorDirection direction) {
        ElevatorController best = null;
        int minDist = Integer.MAX_VALUE;

        for(ElevatorController elevatorController: elevatorControllerList){
            int nextFloorStoppage = elevatorController.elevatorCar.nextFloorStoppage;

            boolean isSameDirection = elevatorController.elevatorCar.movingDirection == direction &&
                    ((direction == ElevatorDirection.UP && nextFloorStoppage<=requestFloor) ||
                            (direction == ElevatorDirection.DOWN && nextFloorStoppage>=requestFloor));

            int dist = Math.abs(requestFloor - nextFloorStoppage);
            if(isSameDirection && dist<minDist){
                minDist = dist;
                best = elevatorController;
            }
        }
        if (best == null) {
            for (ElevatorController controller : elevatorControllerList) {
                if(controller.elevatorCar.movingDirection == ElevatorDirection.IDLE) {
                    best = controller;
                    break;
                }
            }
            if(best == null) {
                best = elevatorControllerList.get(0);
            }
        }
        return best;

    }
}

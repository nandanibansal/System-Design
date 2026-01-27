package ElevatorStrategy;

import ElevatorOperation.ElevatorController;
import Enums.ElevatorDirection;

import java.util.List;

public class LeastBusyStrategy implements ElevatorSelectStrategy{

    @Override
    public ElevatorController selectElevator(List<ElevatorController> elevatorControllerList, int requestFloor, ElevatorDirection direction) {
        ElevatorController best = null;
        int minLoad = Integer.MAX_VALUE;

        for(ElevatorController elevatorController: elevatorControllerList){
            int load = elevatorController.upMinPQ.size() + elevatorController.downMaxPQ.size();
            if(minLoad>load){
                minLoad=load;
                best = elevatorController;
            }
        }
        return best;
    }
}

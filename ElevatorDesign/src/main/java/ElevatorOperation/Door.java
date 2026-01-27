package ElevatorOperation;

import Enums.DoorState;

public class Door {
    private DoorState doorState;

    public void openDoor(int id){
        doorState = DoorState.DOOR_OPENED;
        System.out.println("Opening the door for elevator: "+ id);
    }

    public void closeDoor(int id){
        doorState = DoorState.DOOR_CLOSED;
        System.out.println("Closing the door for elevator: "+ id);
    }


}

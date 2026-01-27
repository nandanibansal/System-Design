package ElevatorOperation;

import Enums.ElevatorDirection;

public class ElevatorCar {
    int id;
    int currentFloor;
    public int nextFloorStoppage;
    public ElevatorDirection movingDirection;
    Door door;

    public ElevatorCar(int id){
        this.id = id;
        currentFloor = 0;
        movingDirection = ElevatorDirection.IDLE;
        door = new Door();
    }

    public void showDisplay(){
        System.out.println("elevator:" + id + " Current floor: " + currentFloor + " going: " + movingDirection);
    }

    public void moveElevator(int destinationFloor){
        this.nextFloorStoppage = destinationFloor;
        if(this.currentFloor == nextFloorStoppage){
            door.openDoor(id);
            return;
        }

        int startFloor = this.currentFloor;
        door.closeDoor(id);
        if(nextFloorStoppage >= currentFloor){
            movingDirection = ElevatorDirection.UP;
            showDisplay();

            for(int i = startFloor+1; i<=nextFloorStoppage; i++){
                try{
                    Thread.sleep(5);
                }catch (Exception e){
                    System.out.println("Error in lift");
                }
                setCurrentFloor(i);
                showDisplay();
            }
        }
        else{
            movingDirection = ElevatorDirection.DOWN;
            showDisplay();

            for(int i = startFloor-1; i>=nextFloorStoppage; i--){
                try{
                    Thread.sleep(5);

                }catch (Exception e){
                    System.out.println("Error in lift");
                }
                setCurrentFloor(i);
                showDisplay();
            }
        }
        door.openDoor(id);
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
package ElevatorOperation;

public class InternalDispatcher {
    private static InternalDispatcher INSTANCE = new InternalDispatcher();

    public static InternalDispatcher getInstance() {
        return INSTANCE;
    }

    public void submitExternalRequest(int destinationFloor, ElevatorController elevatorController) {
        elevatorController.submitRequest(destinationFloor);
    }
}

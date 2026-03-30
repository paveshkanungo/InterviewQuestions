package org.example.elevator;

public class InternalDispatcher {
    private static InternalDispatcher INSTANCE = new InternalDispatcher();

    private InternalDispatcher() {}

    public static InternalDispatcher getInstance() {
        return INSTANCE;
    }

    public void submitInternalRequest(int destinationFloor, ElevatorController controller) {
        controller.submitRequest(destinationFloor);
    }
}

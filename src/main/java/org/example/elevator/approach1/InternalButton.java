package org.example.elevator.approach1;

public class InternalButton {
    private final ElevatorController controller;

    public InternalButton(ElevatorController controller){
        this.controller = controller;
    }

    public void pressButton(int destinationFloor) {
        InternalDispatcher.getInstance().submitInternalRequest(destinationFloor, controller);
    }

}

package org.example.elevator.approach1;

import org.example.elevator.approach1.enums.ElevatorDirection;

public class ExternalButton {
    private final ExternalDispatcher dispatcher;

    public ExternalButton(ExternalDispatcher dispatcher){
        this.dispatcher = dispatcher;
    }

    // this direction of elevator is helpful in selecting the correct elevator/controller.
    public void pressButton(int floor, ElevatorDirection direction){
        dispatcher.submitExternalRequest(floor, direction);
    }
}

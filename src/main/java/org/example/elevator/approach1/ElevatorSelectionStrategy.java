package org.example.elevator.approach1;

import org.example.elevator.approach1.enums.ElevatorDirection;

import java.util.List;

public interface ElevatorSelectionStrategy {
    ElevatorController selectElevator(List<ElevatorController> controllers, int requestFloor, ElevatorDirection direction);
}

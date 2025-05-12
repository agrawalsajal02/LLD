package lld.LLDElevatorDesign;

import java.util.List;

public class EvenOddDispatchStrategy implements DispatchStrategy {

    List<ElevatorController> elevatorControllers = ElevatorCreator.elevatorControllerList;

    @Override
    public ElevatorController selectElevator(int floor, Direction direction) {
        for (ElevatorController controller : elevatorControllers) {
            int id = controller.elevatorCar.id;
            if ((id % 2 == 0 && floor % 2 == 0) || (id % 2 == 1 && floor % 2 == 1)) {
                return controller;
            }
        }
        return elevatorControllers.get(0); // fallback
    }
}

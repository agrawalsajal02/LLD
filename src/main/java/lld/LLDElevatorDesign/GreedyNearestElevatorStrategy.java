package lld.LLDElevatorDesign;

import java.util.List;

public class GreedyNearestElevatorStrategy implements DispatchStrategy {

    List<ElevatorController> elevatorControllers = ElevatorCreator.elevatorControllerList;

    @Override
    public ElevatorController selectElevator(int floor, Direction direction) {
        ElevatorController bestController = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorController controller : elevatorControllers) {
            ElevatorCar car = controller.elevatorCar;
            int distance = Math.abs(car.currentFloor - floor);

            if (car.elevatorState == ElevatorState.IDLE ||
                    (car.elevatorDirection == direction &&
                            ((direction == Direction.UP && car.currentFloor <= floor) ||
                                    (direction == Direction.DOWN && car.currentFloor >= floor)))) {

                if (distance < minDistance) {
                    minDistance = distance;
                    bestController = controller;
                }
            }
        }

        if (bestController == null) {
            for (ElevatorController controller : elevatorControllers) {
                if (controller.elevatorCar.elevatorState == ElevatorState.IDLE) {
                    return controller;
                }
            }
        }

        return bestController != null ? bestController : elevatorControllers.get(0);
    }
}

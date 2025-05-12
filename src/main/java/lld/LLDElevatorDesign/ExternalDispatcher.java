package lld.LLDElevatorDesign;

import java.util.List;

import static lld.LLDElevatorDesign.ElevatorCreator.elevatorControllerList;

public class ExternalDispatcher {

    private DispatchStrategy strategy;

    public ExternalDispatcher(DispatchStrategy strategy) {
        this.strategy = strategy;
    }


    public void submitExternalRequest(int floor, Direction direction) {
        ElevatorController selectedController = strategy.selectElevator(floor, direction);
        if (selectedController != null) {
            selectedController.submitExternalRequest(floor, direction);
        }
    }

    public void setStrategy(DispatchStrategy strategy) {
        this.strategy = strategy;
    }


    public void submitExternalRequest0(int floor, Direction direction){



//        🔍 This is a static dispatching rule:
//        Odd floors → Odd ID elevators
//
//        Even floors → Even ID elevators

        //for simplicity, i am following even odd,
        for(ElevatorController elevatorController : elevatorControllerList) {

           int elevatorID = elevatorController.elevatorCar.id;
           if (elevatorID%2==1 && floor%2==1){
               elevatorController.submitExternalRequest(floor,direction);
           } else if(elevatorID%2==0 && floor%2==0){
               elevatorController.submitExternalRequest(floor,direction);

           }
        }
    }


    public void submitExternalRequest2(int floor, Direction direction) {
        ElevatorController bestController = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorController controller : elevatorControllerList) {
            ElevatorCar car = controller.elevatorCar;

            // If elevator is idle or moving in requested direction and will pass the floor
            if (car.elevatorState == ElevatorState.IDLE ||
                    (car.elevatorDirection == direction &&
                            ((direction == Direction.UP && car.currentFloor <= floor) ||
                                    (direction == Direction.DOWN && car.currentFloor >= floor)))) {

                int distance = Math.abs(car.currentFloor - floor);
                if (distance < minDistance) {
                    minDistance = distance;
                    bestController = controller;
                }
            }
        }

        // If no bestController found (all busy or not matching), assign to any idle one
        if (bestController == null) {
            for (ElevatorController controller : elevatorControllerList) {
                if (controller.elevatorCar.elevatorState == ElevatorState.IDLE) {
                    bestController = controller;
                    break;
                }
            }
        }

        // Fallback: pick random controller
        if (bestController == null && !elevatorControllerList.isEmpty()) {
            bestController = elevatorControllerList.get(0);
        }

        if (bestController != null) {
            bestController.submitExternalRequest(floor, direction);
        }
    }


}

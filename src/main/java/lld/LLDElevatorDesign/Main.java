package lld.LLDElevatorDesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        DispatchStrategy strategy = new GreedyNearestElevatorStrategy(); // or EvenOddDispatchStrategy
        List<Floor> floorList = new ArrayList<>();
        Floor floor1 = new Floor(1, strategy);
        Floor floor2 = new Floor(2, strategy);
        Floor floor3 = new Floor(3, strategy);
        Floor floor4 = new Floor(4, strategy);
        Floor floor5 = new Floor(5, strategy);
        floorList.add(floor1);
        floorList.add(floor2);
        floorList.add(floor3);
        floorList.add(floor4);
        floorList.add(floor5);

        Building building = new Building(Arrays.asList(floor1, floor2, floor3, floor4));


        floor1.pressButton(Direction.UP);
        floor3.pressButton(Direction.UP);
        floor4.pressButton(Direction.UP);
        floor2.pressButton(Direction.DOWN);
        floor1.pressButton(Direction.DOWN);
    }
}
//
//| **Class**                 | **Owned By / Manages**            | **Responsibility**                                                 |
//        | ------------------------- | --------------------------------- | ------------------------------------------------------------------ |
//        | `Building`                | Owns a list of `Floor` objects    | Manages building-level structure                                   |
//        | `Floor`                   | Owned by `Building`               | Simulates physical floor; raises external requests                 |
//        | `ElevatorCar`             | Owned by `ElevatorController`     | Represents an individual elevator (state, movement, door, display) |
//        | `ElevatorController`      | Controls a specific `ElevatorCar` | Handles scheduling logic and request queues (LOOK algorithm)       |
//        | `ElevatorDisplay`         | Used by `ElevatorCar`             | Shows current floor and direction                                  |
//        | `ElevatorDoor`            | Used by `ElevatorCar`             | Simulates opening/closing door                                     |
//        | `InternalButtons`         | Used by `ElevatorCar`             | Captures internal floor requests                                   |
//        | `InternalDispatcher`      | Shared utility                    | Forwards internal requests to appropriate `ElevatorController`     |
//        | `ExternalDispatcher`      | Shared utility                    | Forwards external requests to appropriate `ElevatorController`     |
//        | `ElevatorCreator`         | Static factory class              | Creates and owns `ElevatorController` list                         |
//        | `Request` / `RequestType` | Shared model class                | Describes a floor request and its type (internal/external)         |
//

//
//🔁 Process Flow: Internal Button Press (Inside Elevator)
//📍 Scenario: Passenger presses button 5 inside elevator
//🔽 Step-by-step
//User presses internal button 5
//
//        ElevatorCar.pressButton(5) is called.
//
//ElevatorCar calls InternalButtons.pressButton(destination, this)
//
//Validates the button (optional).
//
//Delegates to the internal dispatcher.
//
//        InternalDispatcher.submitInternalRequest(floor, elevatorCar)
//
//Iterates through all controllers to find the matching ElevatorController.
//
//Matching ElevatorController.submitInternalRequest(floor)
//
//Adds the floor to either upMinPQ or downMaxPQ based on elevator's current floor.
//
//        ElevatorController.controlElevator()
//
//Runs in a background thread.
//
//Picks the next job using LOOK logic.
//
//Moves the elevator → opens door → closes door → updates display.
//
//        ⬆️ Process Flow: External Button Press (From a Floor)
//📍 Scenario: Someone on floor 3 presses UP
//🔽 Step-by-step
//User calls Floor.pressButton(Direction.UP)
//
//Simulates pressing an external floor call.
//
//        ExternalDispatcher.submitExternalRequest(floorNumber, direction)
//
//Applies a dispatching logic (even/odd elevator assignment here).
//
//Dispatches request to appropriate ElevatorController.submitExternalRequest(floor, direction)
//
//Adds the floor to either upMinPQ or downMaxPQ.
//
//        ElevatorController.controlElevator()
//
//Same thread as internal: handles queueing, servicing, and direction switching.
//
//        🔄 What Triggers the Processing?
//        ElevatorController.controlElevator() must run continuously (e.g., in its own thread).
//
//Both internal and external requests just enqueue destinations.
//
//Actual execution is done inside controlElevator() using LOOK scheduling logic:
//
//Services closest floors in current direction.
//
//Reverses direction only when no further requests are pending in current direction.
//

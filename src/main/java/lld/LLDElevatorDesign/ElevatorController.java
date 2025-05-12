package lld.LLDElevatorDesign;

import java.util.*;

public class ElevatorController {
    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;
    Queue<Request> pendingJobs; // store requests when they can't be served immediately

    ElevatorCar elevatorCar;

    ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a, b) -> b - a);
        pendingJobs = new LinkedList<>();
    }

    public void submitExternalRequest(int floor, Direction direction) {
        Direction currentDirection = elevatorCar.elevatorDirection;

        if (currentDirection == Direction.UP && floor < elevatorCar.currentFloor) {
            deferJob(floor, direction);
        } else if (currentDirection == Direction.DOWN && floor > elevatorCar.currentFloor) {
            deferJob(floor, direction);
        } else {
            // Acceptable in current direction
            if (direction == Direction.UP) {
                upMinPQ.offer(floor);
            } else {
                downMaxPQ.offer(floor);
            }
        }
    }


    public void submitInternalRequest(int floor) {
        if (floor == elevatorCar.currentFloor) {
            // Optional: if already at floor, just open door
            elevatorCar.elevatorDoor.openDoor();
            elevatorCar.elevatorDoor.closeDoor();
            return;
        }

        Direction currentDirection = elevatorCar.elevatorDirection;

        if (currentDirection == Direction.UP) {
            if (floor > elevatorCar.currentFloor) {
                upMinPQ.offer(floor);
            } else {
                deferJob(floor, Direction.DOWN);  // defer for later
            }
        } else if (currentDirection == Direction.DOWN) {
            if (floor < elevatorCar.currentFloor) {
                downMaxPQ.offer(floor);
            } else {
                deferJob(floor, Direction.UP); // defer for later
            }
        } else {
            // Elevator is IDLE, pick direction based on destination
            if (floor > elevatorCar.currentFloor) {
                elevatorCar.elevatorDirection = Direction.UP;
                upMinPQ.offer(floor);
            } else {
                elevatorCar.elevatorDirection = Direction.DOWN;
                downMaxPQ.offer(floor);
            }
        }
    }


    public void controlElevator() {

//        Runs in a background thread.
//
//        Picks the next job using LOOK logic.
//
//        Moves the elevator → opens door → closes door → updates display.
//

        while (true) {
            if (elevatorCar.elevatorDirection == Direction.UP) {
                while (!upMinPQ.isEmpty() && upMinPQ.peek() >= elevatorCar.currentFloor) {
                    int floor = upMinPQ.poll();
                    elevatorCar.moveElevator(Direction.UP, floor);
                    elevatorCar.elevatorDoor.openDoor();
                    elevatorCar.elevatorDoor.closeDoor();
                }

                // Check if there are downward jobs now
                if (!downMaxPQ.isEmpty()) {
                    elevatorCar.elevatorDirection = Direction.DOWN;
                } else if (!pendingJobs.isEmpty()) {
                    processPendingJobs();
                } else {
                    elevatorCar.elevatorDirection = Direction.IDLE;
                }
            } else if (elevatorCar.elevatorDirection == Direction.DOWN) {
                while (!downMaxPQ.isEmpty() && downMaxPQ.peek() <= elevatorCar.currentFloor) {
                    int floor = downMaxPQ.poll();
                    elevatorCar.moveElevator(Direction.DOWN, floor);
                    elevatorCar.elevatorDoor.openDoor();
                    elevatorCar.elevatorDoor.closeDoor();
                }

                // Check if there are upward jobs now
                if (!upMinPQ.isEmpty()) {
                    elevatorCar.elevatorDirection = Direction.UP;
                } else if (!pendingJobs.isEmpty()) {
                    processPendingJobs();
                } else {
                    elevatorCar.elevatorDirection = Direction.IDLE;
                }
            } else { // elevator is IDLE
                // Check for any jobs
                if (!upMinPQ.isEmpty()) {
                    elevatorCar.elevatorDirection = Direction.UP;
                } else if (!downMaxPQ.isEmpty()) {
                    elevatorCar.elevatorDirection = Direction.DOWN;
                } else if (!pendingJobs.isEmpty()) {
                    processPendingJobs();
                }
            }

            try {
                Thread.sleep(1000); // Simulate a time step
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void processPendingJobs() {
        while (!pendingJobs.isEmpty()) {
            Request req = pendingJobs.poll();
            submitExternalRequest(req.floor, req.direction);
        }
    }

    // Optional: if you want to queue jobs that can't be served immediately
    public void deferJob(int floor, Direction direction) {
        pendingJobs.offer(new Request(floor, direction, RequestType.EXTERNAL));
    }
}

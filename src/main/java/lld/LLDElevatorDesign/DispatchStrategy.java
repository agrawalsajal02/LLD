package lld.LLDElevatorDesign;

public interface DispatchStrategy {
    ElevatorController selectElevator(int floor, Direction direction);
}
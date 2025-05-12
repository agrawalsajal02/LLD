package lld.LLDElevatorDesign;

public class Floor {
    int floorNumber;
    ExternalDispatcher externalDispatcher;

    public Floor(int floorNumber, DispatchStrategy strategy) {
        this.floorNumber = floorNumber;
        this.externalDispatcher = new ExternalDispatcher(strategy);
    }

    public void pressButton(Direction direction) {
        externalDispatcher.submitExternalRequest(floorNumber, direction);
    }
}

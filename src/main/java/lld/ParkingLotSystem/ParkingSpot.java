package lld.ParkingLotSystem;
public class ParkingSpot {
    private boolean isEmpty;
    private Vehicle vehicle;

    public ParkingSpot() {
        this.isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}


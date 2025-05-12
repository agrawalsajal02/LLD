package lld.ParkingLotSystem;

public class Ticket {
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private long entryTime;
    private long exitTime;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = System.currentTimeMillis();
    }

    public void setExitTime() {
        this.exitTime = System.currentTimeMillis();
    }

    public long getParkingDurationInHours() {
        return (exitTime - entryTime) / (1000 * 60 * 60);
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}


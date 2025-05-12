package lld.ParkingLotSystem;

public class ParkingLot {
    private ParkingSpotManager twoWheelerManager;
    private ParkingSpotManager fourWheelerManager;

    public ParkingLot(int twoWheelerCapacity, int fourWheelerCapacity) {
        this.twoWheelerManager = new ParkingSpotManager(twoWheelerCapacity);
        this.fourWheelerManager = new ParkingSpotManager(fourWheelerCapacity);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = null;
        if (vehicle.getVehicleType() == VehicleType.TWO_WHEELER) {
            spot = twoWheelerManager.getAvailableSpot();
        } else if (vehicle.getVehicleType() == VehicleType.FOUR_WHEELER) {
            spot = fourWheelerManager.getAvailableSpot();
        }

        if (spot != null) {
            spot.parkVehicle(vehicle);
            return new Ticket(vehicle, spot);
        }

        return null; // No available spot
    }

    public int removeVehicle(Ticket ticket) {
        ticket.setExitTime();
        Vehicle vehicle = ticket.getVehicle();

        if (vehicle.getVehicleType() == VehicleType.TWO_WHEELER) {
            twoWheelerManager.removeVehicle(vehicle);
            return TwoWheelerSpot.PRICE * (int) ticket.getParkingDurationInHours();
        } else {
            fourWheelerManager.removeVehicle(vehicle);
            return FourWheelerSpot.PRICE * (int) ticket.getParkingDurationInHours();
        }
    }
}


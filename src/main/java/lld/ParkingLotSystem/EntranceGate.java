package lld.ParkingLotSystem;

public class EntranceGate {
    private ParkingSpotManager twoWheelerManager;
    private ParkingSpotManager fourWheelerManager;

    public EntranceGate(ParkingSpotManager twoWheelerManager, ParkingSpotManager fourWheelerManager) {
        this.twoWheelerManager = twoWheelerManager;
        this.fourWheelerManager = fourWheelerManager;
    }

    public Ticket generateTicket(Vehicle vehicle) {
        ParkingSpot spot = null;

        if (vehicle.getVehicleType() == VehicleType.TWO_WHEELER) {
            spot = twoWheelerManager.getAvailableSpot();
        } else if (vehicle.getVehicleType() == VehicleType.FOUR_WHEELER) {
            spot = fourWheelerManager.getAvailableSpot();
        }

        if (spot != null) {
            // Create new instance of the appropriate spot using factory
            ParkingSpot concreteSpot = ParkingSpotFactory.createParkingSpot(vehicle.getVehicleType());
            concreteSpot.parkVehicle(vehicle);

            // Replace placeholder with actual parked spot in manager list (optional if factory is needed for spot type only)
            spot.parkVehicle(vehicle);

            return new Ticket(vehicle, spot);
        }

        System.out.println("No available spot for " + vehicle.getVehicleType());
        return null;
    }
}


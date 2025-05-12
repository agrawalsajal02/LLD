package lld.ParkingLotSystem;

public class ParkingSpotFactory {
    public static ParkingSpot createParkingSpot(VehicleType type) {
        switch (type) {
            case TWO_WHEELER:
                return new TwoWheelerSpot();
            case FOUR_WHEELER:
                return new FourWheelerSpot();
            default:
                throw new IllegalArgumentException("Unsupported vehicle type");
        }
    }
}


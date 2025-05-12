package lld.ParkingLotSystem;

import java.util.List;
import java.util.ArrayList;

public class ParkingSpotManager {
    private List<ParkingSpot> spots;

    public ParkingSpotManager(int capacity) {
        spots = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            spots.add(new ParkingSpot());
        }
    }

    public ParkingSpot getAvailableSpot() {
        for (ParkingSpot spot : spots) {
            if (spot.isEmpty()) {
                return spot;
            }
        }
        return null;
    }

    public void removeVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isEmpty() && spot.getVehicle().equals(vehicle)) {
                spot.removeVehicle();
                break;
            }
        }
    }
}


package lld.LLDCarRentalSystem.V2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class VehicleInventoryMap {
    Map<VehicleType, List<Vehicle>> inventory = new HashMap<>();

    public void addVehicle(Vehicle vehicle) {
        inventory.computeIfAbsent(vehicle.type, k -> new ArrayList<>()).add(vehicle);
    }

    public List<Vehicle> getVehiclesByType(VehicleType type) {
        return inventory.getOrDefault(type, new ArrayList<>());
    }
}

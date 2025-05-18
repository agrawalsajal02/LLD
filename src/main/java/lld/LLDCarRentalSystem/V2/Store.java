package lld.LLDCarRentalSystem.V2;

import java.util.List;

class Store {
    String storeId;
    Location location;
    VehicleInventoryMap inventoryMap = new VehicleInventoryMap();

    public Store(String storeId, Location location) {
        this.storeId = storeId;
        this.location = location;
    }

    public List<Vehicle> searchVehicles(VehicleType type) {
        return inventoryMap.getVehiclesByType(type);
    }
}


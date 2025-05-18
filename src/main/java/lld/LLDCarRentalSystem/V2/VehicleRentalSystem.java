package lld.LLDCarRentalSystem.V2;

import java.util.ArrayList;
import java.util.List;

class VehicleRentalSystem {
    List<Store> stores = new ArrayList<>();

    public void addStore(Store store) {
        stores.add(store);
    }

    public List<Vehicle> searchVehicle(Location location, VehicleType type) {
        for (Store store : stores) {
            if (store.location.city.equals(location.city)) {
                return store.searchVehicles(type);
            }
        }
        return new ArrayList<>();
    }
}


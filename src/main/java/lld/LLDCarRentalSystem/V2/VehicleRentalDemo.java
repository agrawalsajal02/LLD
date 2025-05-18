package lld.LLDCarRentalSystem.V2;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class VehicleRentalDemo {
    public static void main(String[] args) {
        VehicleRentalSystem system = new VehicleRentalSystem();

        // Setup
        Location blr = new Location("Bangalore", "KA", "560001");
        Store store1 = new Store("S1", blr);
        store1.inventoryMap.addVehicle(new Car("C1", "i20", "Hyundai", 200));
        system.addStore(store1);

        // User Flow
        User user = new User("U1", "Sajal");
        List<Vehicle> availableCars = system.searchVehicle(blr, VehicleType.CAR);

        if (!availableCars.isEmpty()) {
            Vehicle selected = availableCars.get(0);

            // remember this
            Date start = new Date(); // now
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.HOUR, 3); // 3 hours later
            Date end = cal.getTime();

            Reservation res = user.createReservation(selected, start, end);
            Bill bill = res.generateBill();
            bill.makePayment("UPI");
        }
    }
}

//
//
//VehicleRentalSystem
// ├── List<Store>
// └── searchVehicle(location, dateRange)
//
//Store
// ├── Location
// └── VehicleInventoryMap (Map<VehicleType, List<Vehicle>>)
//
//User
// └── createReservation(vehicle, startDate, endDate)
//
//Reservation
// ├── Vehicle
// ├── User
// └── generateBill()
//
//Bill
// └── makePayment()
//
//Vehicle → Car, Bike, etc.


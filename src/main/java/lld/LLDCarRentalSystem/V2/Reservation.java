package lld.LLDCarRentalSystem.V2;

import java.util.Date;
import java.util.UUID;

class Reservation {
    String reservationId = UUID.randomUUID().toString();
    User user;
    Vehicle vehicle;
    Date startTime;
    Date endTime;

    public Reservation(User user, Vehicle vehicle, Date start, Date end) {
        this.user = user;
        this.vehicle = vehicle;
        this.startTime = start;
        this.endTime = end;
    }

    public Bill generateBill() {
        long duration = (endTime.getTime() - startTime.getTime()) / (1000 * 60 * 60); // in hours
        double amount = duration * vehicle.hourlyRate;
        return new Bill(this, amount);
    }
}

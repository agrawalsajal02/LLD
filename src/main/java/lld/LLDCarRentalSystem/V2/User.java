package lld.LLDCarRentalSystem.V2;

import java.util.Date;

class User {
    String userId;
    String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public Reservation createReservation(Vehicle vehicle, Date start, Date end) {
        return new Reservation(this, vehicle, start, end);
    }
}


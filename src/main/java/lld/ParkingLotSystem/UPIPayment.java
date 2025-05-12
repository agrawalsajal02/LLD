package lld.ParkingLotSystem;

public class UPIPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " via UPI.");
    }
}


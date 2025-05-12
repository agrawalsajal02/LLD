package lld.ParkingLotSystem;

public class HourlyPricingStrategy implements PricingStrategy {
    private int pricePerHour;

    public HourlyPricingStrategy(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public int calculateFare(long durationInMinutes) {
        int hours = (int) Math.ceil(durationInMinutes / 60.0);
        return hours * pricePerHour;
    }
}


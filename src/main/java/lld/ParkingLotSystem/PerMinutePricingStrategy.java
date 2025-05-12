package lld.ParkingLotSystem;

public class PerMinutePricingStrategy implements PricingStrategy {
    private int pricePerMinute;

    public PerMinutePricingStrategy(int pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    @Override
    public int calculateFare(long durationInMinutes) {
        return (int) durationInMinutes * pricePerMinute;
    }
}


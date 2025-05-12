package lld.ParkingLotSystem;

public class TicketComputation {
    private PricingStrategy strategy;

    public TicketComputation(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public int computeFare(Ticket ticket) {
        ticket.setExitTime();  // Capture exit time
        long durationInMinutes = (ticket.getParkingDurationInHours() * 60); // Approximate or calculate exact
        return strategy.calculateFare(durationInMinutes);
    }
}


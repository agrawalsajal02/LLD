package lld.ParkingLotSystem;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingSpotManager twoManager = new ParkingSpotManager(2);
        ParkingSpotManager fourManager = new ParkingSpotManager(2);

        EntranceGate entranceGate = new EntranceGate(twoManager, fourManager);
        Vehicle vehicle = new Vehicle("KA01XX1234", VehicleType.TWO_WHEELER) {};
        Ticket ticket = entranceGate.generateTicket(vehicle);

        // Simulate time
        Thread.sleep(2000); // 2 seconds = ~0 mins

        PricingStrategy strategy = new PerMinutePricingStrategy(2);
        TicketComputation computation = new TicketComputation(strategy);
        ExitGate exitGate = new ExitGate(twoManager, fourManager, computation);

        Payment payment = new CashPayment(); // Or new UPIPayment()
        exitGate.processExit(ticket, payment);
    }
}

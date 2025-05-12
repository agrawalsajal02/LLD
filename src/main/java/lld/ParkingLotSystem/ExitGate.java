package lld.ParkingLotSystem;

public class ExitGate {
    private ParkingSpotManager twoWheelerManager;
    private ParkingSpotManager fourWheelerManager;
    private TicketComputation ticketComputation;

    public ExitGate(ParkingSpotManager twoWheelerManager, ParkingSpotManager fourWheelerManager, TicketComputation ticketComputation) {
        this.twoWheelerManager = twoWheelerManager;
        this.fourWheelerManager = fourWheelerManager;
        this.ticketComputation = ticketComputation;
    }

    public void processExit(Ticket ticket, Payment paymentMethod) {
        Vehicle vehicle = ticket.getVehicle();

        int fare = ticketComputation.computeFare(ticket);

        paymentMethod.pay(fare);

        if (vehicle.getVehicleType() == VehicleType.TWO_WHEELER) {
            twoWheelerManager.removeVehicle(vehicle);
        } else {
            fourWheelerManager.removeVehicle(vehicle);
        }

        System.out.println("Vehicle exited. Paid amount: ₹" + fare);
    }
}

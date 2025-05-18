package lld.LLDCarRentalSystem.V2;

class Bill {
    Reservation reservation;
    double amount;

    public Bill(Reservation reservation, double amount) {
        this.reservation = reservation;
        this.amount = amount;
    }

    public Payment makePayment(String method) {
        return new Payment(UUID.randomUUID().toString(), amount, method);
    }
}


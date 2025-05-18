package lld.LLDCarRentalSystem.V2;

class Payment {
    String paymentId;
    double amount;
    String method;

    public Payment(String id, double amount, String method) {
        this.paymentId = id;
        this.amount = amount;
        this.method = method;
        System.out.println("Payment of ₹" + amount + " completed via " + method);
    }
}


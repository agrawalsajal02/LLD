package designPattern.mediatorDesignPattern;


// Concrete Colleague
class Bidder implements Colleague {
    private String name;
    private ActionMediator mediator;

    public Bidder(String name, ActionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.addBidder(this);
    }

    @Override
    public void placeBid(int amount) {
        System.out.println(name + " is placing a bid of " + amount);
        mediator.placeBid(this, amount);
    }

    @Override
    public void receiveNotification(String message) {
        System.out.println(name + " received: " + message);
    }

    @Override
    public String getName() {
        return name;
    }
}
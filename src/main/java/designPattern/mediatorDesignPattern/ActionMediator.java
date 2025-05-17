package designPattern.mediatorDesignPattern;

// Mediator interface
interface ActionMediator {
    void addBidder(Colleague bidder);
    void placeBid(Colleague bidder, int bidAmount);
}

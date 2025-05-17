package designPattern.mediatorDesignPattern;

import java.util.ArrayList;
import java.util.List;

// Concrete Mediator
class Auction implements ActionMediator {
    private List<Colleague> bidders = new ArrayList<>();
    private int highestBid = 0;
    private Colleague highestBidder = null;

    @Override
    public void addBidder(Colleague bidder) {
        bidders.add(bidder);
        System.out.println(bidder.getName() + " has joined the auction.");
    }

    @Override
    public void placeBid(Colleague bidder, int bidAmount) {
        if (bidAmount > highestBid) {
            highestBid = bidAmount;
            highestBidder = bidder;
            notifyAllBidders(bidder.getName() + " placed the highest bid of " + bidAmount);
        } else {
            bidder.receiveNotification("Your bid of " + bidAmount + " is too low. Current highest: " + highestBid);
        }
    }

    private void notifyAllBidders(String message) {
        for (Colleague bidder : bidders) {
            bidder.receiveNotification(message);
        }
    }
}

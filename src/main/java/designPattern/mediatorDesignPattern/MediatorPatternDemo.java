package designPattern.mediatorDesignPattern;

public class MediatorPatternDemo {
    public static void main(String[] args) {
        ActionMediator auction = new Auction();

        Colleague bidder1 = new Bidder("Alice", auction);
        Colleague bidder2 = new Bidder("Bob", auction);
        Colleague bidder3 = new Bidder("Charlie", auction);

        bidder1.placeBid(100);
        bidder2.placeBid(120);
        bidder3.placeBid(110);
        bidder1.placeBid(150);
    }
}


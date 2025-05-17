package designPattern.mediatorDesignPattern;

interface Colleague {
    void placeBid(int amount);
    void receiveNotification(String message);
    String getName();
}

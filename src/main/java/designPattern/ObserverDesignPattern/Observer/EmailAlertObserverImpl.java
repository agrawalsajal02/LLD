package designPattern.ObserverDesignPattern.Observer;

import designPattern.ObserverDesignPattern.Observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{
    StocksObservable observable;
    String userName;

    public EmailAlertObserverImpl(String emailId,StocksObservable observable){
        this.observable=observable;
        this.userName=emailId;
    }

    @Override
    public void update() {
        sendMail(userName,"product is in stock hurry up !");
    }

    private void sendMail(String userName, String msg) {
        System.out.println("mail sent to: "+userName);
        //send the actual mail
    }

}

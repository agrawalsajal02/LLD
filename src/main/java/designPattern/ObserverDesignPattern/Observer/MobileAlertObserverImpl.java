package designPattern.ObserverDesignPattern.Observer;

import designPattern.ObserverDesignPattern.Observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{
    String userName;
    StocksObservable observable;

    public MobileAlertObserverImpl(String emailId,StocksObservable observable){
        this.observable=observable;
        this.userName=emailId;
    }

    @Override
    public void update() {
        sendMsgOnMobile(userName,"product is in stock hurry up !");
    }

    private void sendMsgOnMobile(String userName, String msg) {
        System.out.println("msg sent to: "+userName);
        //send the actual sms
    }
}

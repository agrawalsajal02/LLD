package designPattern.ObserverDesignPattern;

import designPattern.ObserverDesignPattern.Observable.IphoneObservableImpl;
import designPattern.ObserverDesignPattern.Observable.StocksObservable;
import designPattern.ObserverDesignPattern.Observer.EmailAlertObserverImpl;
import designPattern.ObserverDesignPattern.Observer.MobileAlertObserverImpl;
import designPattern.ObserverDesignPattern.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StocksObservable iphoneStockObservable=new IphoneObservableImpl();
        NotificationAlertObserver observer1=new EmailAlertObserverImpl("xyz@gmail.com",iphoneStockObservable);
        NotificationAlertObserver observer2=new EmailAlertObserverImpl("xyz@gmail.com",iphoneStockObservable);
        NotificationAlertObserver observer3=new MobileAlertObserverImpl("xyz_username",iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);

    }
}

package designPattern.SingletonDesignPattern;

public class Main {
    // used when we need 1 instance of class like DB connection
    // 4 ways : all of them in common that we have to restrict the creation of object : who is responsible , constructer , so make constructer private , so outside of this class , no one is able to call constructer , expose one method , which other classes can call it using class
    // 1. Eager initlisation : we create static instance variable , when class is loaded , it is created once
    // 2. Lazy : instead of class load time , we initlise when the mehod invokes : problem with multiple thread come at same place where initlisarion happeing
    // 3. Synchronisation : syncrosizeed methosd , it will out the lock , problem , it is very expensive (locking) as it will place lock everytime when it is invokes by 1 thread
    // 4. Double Locking
    // 5.Bill Pugh Singleton (Static Inner Class)
    // 6.Enum Singleton
    // 7. Singleton Using volatile Keyword


//
//    Conclusion:
//    Bill Pugh Singleton (Static Inner Class) is highly favored in Java projects for its thread safety, lazy initialization, and no synchronization overhead. It is a popular choice in enterprise systems where performance is crucial.
//
//    Enum Singleton is recommended for its simplicity, built-in thread safety, serialization protection, and reflection immunity. It is a great choice in cases where simplicity and robustness are more important, and it is endorsed by Java experts, including Joshua Bloch.


//    https://medium.com/@greekykhs/all-about-blockingqueue-cb57350c9793

    public static void main(String[] args) {
        System.out.println("hi");
    }
}

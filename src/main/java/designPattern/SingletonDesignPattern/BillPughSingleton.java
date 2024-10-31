package designPattern.SingletonDesignPattern;

// Extend of EagerInitilisation
public class BillPughSingleton {
    private BillPughSingleton() {
        // private constructor
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}


//The Bill Pugh Singleton approach leverages the Java class loading mechanism to ensure that the singleton instance is created in a thread-safe manner without needing synchronization.
//
//How It Works:
//A static inner helper class is used to hold the singleton instance.
//The instance is created only when the getInstance() method is called, and the inner class is loaded for the first time.
//This method is both thread-safe and efficient because no synchronization or locking is needed.
//
//Advantages:
//
//Thread safety is ensured by the class loader.
//No synchronization overhead.
//The instance is lazily loaded.



package designPattern.SingletonDesignPattern;


public class VolatileDoubleLocking {
    private static volatile VolatileDoubleLocking doubleLocking;

    private VolatileDoubleLocking(){

    }

    synchronized  public static VolatileDoubleLocking getInstance(){
        if(doubleLocking==null){
            synchronized (DoubleLocking.class){
                if(doubleLocking==null){
                    doubleLocking=new VolatileDoubleLocking();
                }
            }
        }
        return doubleLocking;
    }
}
//
//
//This is a variation of the double-checked locking pattern. The volatile keyword ensures that the instance is visible to all threads and that updates to the instance variable are properly handled in a multi-threaded environment. In this case, volatile prevents the object from being partially constructed in a multi-threaded context.
//
//How It Works:
//The volatile keyword ensures that writes to the instance variable are visible to all threads.
//This is particularly useful when using double-checked locking.

//Advantages:
//
//Prevents partially constructed objects from being used by other threads.
//Helps achieve thread-safety with improved performance compared to synchronized methods.


//In a multithreaded environment, threads maintain their own local copies of variables in caches to optimize performance.
//A volatile variable ensures that when one thread updates the value of the variable, all other threads immediately see the updated value. Changes made to the volatile variable are always written back to the main memory and not just the thread's local cache.
//Conversely, every read of a volatile variable is always fetched from the main memory, ensuring the thread sees the most up-to-date value.
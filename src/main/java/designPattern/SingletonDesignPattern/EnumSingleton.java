package designPattern.SingletonDesignPattern;

public enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
        // method functionality
    }
}

//Using an enum to implement a singleton is the simplest and most effective way in Java, as enum values are inherently thread-safe and are guaranteed to have only one instance per JVM. This approach avoids reflection issues, provides serialization safety, and is the preferred way of implementing a singleton in many cases.
//
//How It Works:
//The enum contains a single instance, which can be accessed globally.
//Java ensures that only one instance of an enum is created
//
//        Advantages:
//
//Simplest and cleanest implementation.
//Automatically thread-safe.
//Serialization is handled by Java itself (prevents creating new instances on deserialization).
//Prevents reflection attacks.
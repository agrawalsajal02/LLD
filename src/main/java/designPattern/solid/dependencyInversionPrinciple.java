//package designPattern.solid;
//
//// High level modules should not depend on low level modules . They should dependent on abstraction like interface.
//// To achieve Dependency Inversion we use dependency injection . so instead of creating depenedency , inject them.
//public class dependencyInversionPrinciple {
//    public static void main(String[] args) {
//
//    }
//}
//
////💉 Dependency Injection -----------------------
////        - Instead of creating dependencies, inject them
////        ```java
//class Cage {
//    IFeedingBowl feedingBowl;
//    IBars bars;
//    List<Animal> animals;
//    public Cage(IFeedingBowl feedingBowl,
//                IBars bars,
//                List<Animal> animals) {
//        this.feedingBowl = feedingBowl;
//        this.bars = bars;
//        // don't forget to make a copy here
//        this.animals.addAll(animals); // python: animals[:]
//    }
//}
//class Main {
//    void main() {
//        Cage cage1 = new Cage(new MeatFeedingBowl(),
//                new IronBars(),
//                Arrays.toList(new Tiger(), ...));
//        Cage cage1 = new Cage(new FruitFeedingBowl(),
//    }
//}

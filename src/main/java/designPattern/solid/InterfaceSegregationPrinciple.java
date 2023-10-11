//package designPattern.solid;
//
//// Keep your interfaces minimal
//// No code should be forced to implement a method that it does not need
//public class InterfaceSegregationPrinciple {
//}
//
//interface ICanFly {
//    void fly();
//    void flapWings();
//    void kickToTakeOff();
//}
//
//class Bird{
//
//}
//class Eagle extends Bird implements ICanFly {
//    /* ... */
//}
//// what other things apart from Bird can fly?
//class Airplane extends Vehicle implements ICanFly {
//    @Override
//    void flapWings() { // wtf!?
//    }
//}
//class Shaktiman implements ICanFly {
//    @Override
//    void flapWings() { print("Sorry Shaktiman");
//    }
//}
//class MomChappal implements ICanFly {
//
//}
//

package designPattern.Strategy.Strategy;

public class SportsDriveStrategy  implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Sports Drive Capability");
    }
}

package designPattern.StrategyDesignPattern;

import designPattern.StrategyDesignPattern.Strategy.XYZDriveStrategy;

public class OffRoadVehicle extends Vehicle{
    OffRoadVehicle() {
        super(new XYZDriveStrategy());
    }
}

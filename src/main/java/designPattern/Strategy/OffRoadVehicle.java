package designPattern.Strategy;

import designPattern.Strategy.Strategy.DriveStrategy;
import designPattern.Strategy.Strategy.XYZDriveStrategy;

public class OffRoadVehicle extends Vehicle{
    OffRoadVehicle() {
        super(new XYZDriveStrategy());
    }
}

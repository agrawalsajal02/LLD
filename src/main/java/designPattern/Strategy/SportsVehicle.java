package designPattern.Strategy;

import designPattern.Strategy.Strategy.DriveStrategy;
import designPattern.Strategy.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle{
    SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}

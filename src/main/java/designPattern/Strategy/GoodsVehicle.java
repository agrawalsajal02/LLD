package designPattern.Strategy;

import designPattern.Strategy.Strategy.DriveStrategy;
import designPattern.Strategy.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{
    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}

package lld.parkinglotold.Vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bike implements Vehicle{
    public static final String TYPE="BIKE";
    private String registrationNumber;
    private String color;

    @Override
    public String getVehicleType() {
        return TYPE;
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String getColor() {
        return color;
    }
}

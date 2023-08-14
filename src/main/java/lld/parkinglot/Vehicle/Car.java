package lld.parkinglot.Vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car implements Vehicle{
    public static final String TYPE="CAR";
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

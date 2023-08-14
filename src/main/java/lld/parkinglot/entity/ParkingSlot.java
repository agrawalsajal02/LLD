package lld.parkinglot.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot {
    private Integer floorNumber;
    private String ticket;
    private Boolean isOccupied;
    private String VehicleType;

}

package lld.parkinglot.entity;


import lld.parkinglot.Vehicle.Bike;
import lld.parkinglot.Vehicle.Car;
import lld.parkinglot.Vehicle.Truck;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public class ParkingLot {
    private List<Floor> floorList;
    private String parkingLotId;
    private Integer numberOfFloor;
    private Integer numberOfSlot;

    public ParkingLot(String parkingLotId, Integer numberOfFloor, Integer numberOfSlot) {
        this.parkingLotId = parkingLotId;
        this.numberOfFloor = numberOfFloor;
        this.numberOfSlot = numberOfSlot;
        floorList = new ArrayList<>(numberOfFloor);

        for (int floor = 0; floor < numberOfFloor; floor++) {
            Floor newFloor = new Floor();
            newFloor.setParkingSlots(new ArrayList<>());

            for (int slot = 0; slot < numberOfSlot; slot++) {
                ParkingSlot parkingSlot = new ParkingSlot();
                parkingSlot.setFloorNumber(floor);
                parkingSlot.setIsOccupied(false);

                if (slot == 0) {
                    parkingSlot.setVehicleType(Truck.TYPE);
                } else if (slot == 1 || slot == 2) {
                    parkingSlot.setVehicleType(Bike.TYPE);
                } else {
                    parkingSlot.setVehicleType(Car.TYPE);
                }
                newFloor.getParkingSlots().add(parkingSlot);
            }

            floorList.add(newFloor);
        }
    }

}

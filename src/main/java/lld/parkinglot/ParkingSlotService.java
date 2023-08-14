package lld.parkinglot;


import lld.parkinglot.Vehicle.Vehicle;
import lld.parkinglot.entity.Floor;
import lld.parkinglot.entity.ParkingLot;
import lld.parkinglot.entity.ParkingSlot;
import lombok.Getter;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ParkingSlotService {
    private ParkingLot parkingLot;
    private Map<String, Vehicle>ticketVehicleMap;

     public String createParkingLot(String parkingLotId,Integer numberOfFloor,Integer numberOfSlot){
       parkingLot=new ParkingLot(parkingLotId,numberOfFloor,numberOfSlot);
       ticketVehicleMap=new HashMap<>();

       return "Created parking lot with"+numberOfFloor+" floors and "+numberOfSlot+" slots per floor";
    }

    public void displayFreeCount(Vehicle vehicle){
        final String vehicleType =  vehicle.getVehicleType();

        final List<Floor> floorList = parkingLot.getFloorList();
        for(int j=0;j<floorList.size();j++) {
                final List<ParkingSlot> parkingSlots = floorList.get(j).getParkingSlots();

                Integer slotNumber = 0;
                for (int i = 0; i < parkingSlots.size(); i++) {
                    if (Boolean.FALSE.equals(parkingSlots.get(i).getIsOccupied()) && vehicleType.equals(parkingSlots.get(i).getVehicleType())) {
                        slotNumber ++;
                    }
                }
                System.out.println("No. of free slots for " + vehicleType + " on Floor "+(j+1)+": "+ slotNumber);
        }
    }


    public void displayFreeSlot(Vehicle vehicle){
        final String vehicleType =  vehicle.getVehicleType();

        final List<Floor> floorList = parkingLot.getFloorList();
        for(int j=0;j<floorList.size();j++) {
            final List<ParkingSlot> parkingSlots = floorList.get(j).getParkingSlots();

            System.out.print("Free slots for "+vehicleType+" on Floor "+(j+1)+" : ");

            Integer slotNumber = 0;
            for (int i = 0; i < parkingSlots.size(); i++) {
                if (Boolean.FALSE.equals(parkingSlots.get(i).getIsOccupied()) && vehicleType.equals(parkingSlots.get(i).getVehicleType())) {
                    System.out.print((i+1)+" ");
                }
            }

            System.out.println();
        }
    }

    public void parkVehicle(Vehicle vehicle) {
        //algorithm
        final List<Floor> floorList = parkingLot.getFloorList();

        for (int floor = 0; floor < floorList.size(); floor++) {
            List<ParkingSlot> parkingSlots = floorList.get(floor).getParkingSlots();
            for (int slot = 0; slot < parkingSlots.size(); slot++) {
                if (Boolean.FALSE.equals(parkingSlots.get(slot).getIsOccupied()) &&
                        vehicle.getVehicleType().equals(parkingSlots.get(slot).getVehicleType())) {
                    parkingSlots.get(slot).setIsOccupied(true);
                    final String ticketId = parkingLot.getParkingLotId() + "_" + (floor+1) + "_" + (slot+1);
                    parkingSlots.get(slot).setTicket(ticketId);

                    System.out.println("park_vehicle "+vehicle.getVehicleType()+" "+vehicle.getRegistrationNumber()+ " Ticket : "+ticketId);
                    return;
                }
            }
        }
        System.out.println("Parking Lot Full");
    }

    public void unParkVehicle(final String ticketId) {
        //split the ticketId
        final String[] ticket = ticketId.split("_");
        if (ticket.length != 3) {
            System.out.println("Invalid Ticket");
            return;
        }
        final Integer floor = Integer.parseInt(ticket[1]);
        final Integer slot = Integer.parseInt(ticket[2]);
        if (parkingLot.getFloorList().size() < floor || parkingLot.getFloorList().get(floor).getParkingSlots().size() < slot) {
            System.out.println("Invalid Ticket");
            return;
        }
        final ParkingSlot parkingSlot = parkingLot.getFloorList().get(floor).getParkingSlots().get(slot);
        parkingSlot.setTicket(null);
        parkingSlot.setIsOccupied(false);
        System.out.println("Unparked vehicle");
    }
}

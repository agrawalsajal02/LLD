package lld.parkinglotold.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Floor {
  private List<ParkingSlot>parkingSlots;
  private Integer numberOfSlots;
}

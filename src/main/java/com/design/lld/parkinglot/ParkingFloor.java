package com.design.lld.parkinglot;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ParkingFloor {
    private String name;
    private Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots;

    ParkingFloor(String name, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots) {
        this.name = name;
        this.parkingSlots = parkingSlots;
    }

    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle) {
        VehicleCategory vehicleCategory = vehicle.getVehicleCategory();
        ParkingSlotType parkingSlotType = pickCorrectSlot(vehicleCategory);
        Map<String, ParkingSlot> relevantParkingSlot = parkingSlots.get(parkingSlotType);
        ParkingSlot slot = null;

        for (Map.Entry<String, ParkingSlot> m : relevantParkingSlot.entrySet()) {
            if (m.getValue().isAvailable()) {
                slot = m.getValue();
                slot.addVehicle(vehicle);
                break;
            }
        }
        return slot;
    }

    private ParkingSlotType pickCorrectSlot(VehicleCategory vehicleCategory) {
        if (vehicleCategory.equals(VehicleCategory.TwoWheeler)) {
            return ParkingSlotType.TwoWheeler;
        } else if (vehicleCategory.equals(VehicleCategory.Hatchback)) {
            return ParkingSlotType.Compact;
        } else if (vehicleCategory.equals(VehicleCategory.SUV)) {
            return ParkingSlotType.Large;
        } else if (vehicleCategory.equals(VehicleCategory.Bus)) {
            return ParkingSlotType.Large;
        }
        return null;
    }
}

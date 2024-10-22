package com.design.lld.parkinglot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot {
    private String name;
    private Vehicle vehicle;
    @Builder.Default
    private boolean isAvailable = true;
    private ParkingSlotType parkingSlotType;

    public ParkingSlot(String name, ParkingSlotType parkingSlotType) {
        this.name = name;
        this.parkingSlotType = parkingSlotType;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicle = null;
        this.isAvailable = true;
    }
}

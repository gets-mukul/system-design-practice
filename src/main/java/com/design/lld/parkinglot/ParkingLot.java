package com.design.lld.parkinglot;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ParkingLot {
    private static ParkingLot parkingLot = null;
    private String nameOfParkingLot;
    private Address address;
    private List<ParkingFloor> parkingFloors;

    public ParkingLot(String nameOfParkingLot, Address address,
                      List<ParkingFloor> parkingFloors) {
        this.nameOfParkingLot = nameOfParkingLot;
        this.address = address;
        this.parkingFloors = parkingFloors;

    }

    public static ParkingLot getInstance(String nameOfParkingLot, Address address,
                                         List<ParkingFloor> parkingFloors) {
        if (parkingLot == null) {
            return new ParkingLot(nameOfParkingLot, address, parkingFloors);
        } else {
            return parkingLot;
        }
    }

    public void addFloors(String name, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots) {
        ParkingFloor parkingFloor = new ParkingFloor(name, parkingSlots);
        parkingFloors.add(parkingFloor);
    }

    public void removeFloors(ParkingFloor parkingFloor) {
        parkingFloors.remove(parkingFloor);
    }

    public Ticket assignTicket(Vehicle vehicle) {
        ParkingSlot parkingSlot = getParkingSlotForVehicleAndPark(vehicle);
        if (parkingSlot == null) {
            return null;
        }
        Ticket parkingTicket = createTicketForSlot(parkingSlot, vehicle);
        return parkingTicket;
    }

    public double scanAndPay(Ticket ticket) {
        long endTime = System.currentTimeMillis();
        ticket.getParkingSlot().removeVehicle(ticket.getVehicle());
        int duration = (int) (endTime - ticket.getStartTime()) / 1000;
        double price = ticket.getParkingSlot().getParkingSlotType().getPriceForParking(duration);
        return price;
    }

    private Ticket createTicketForSlot(ParkingSlot parkingSlot, Vehicle vehicle) {
        return Ticket.createTicket(vehicle, parkingSlot);
    }

    private ParkingSlot getParkingSlotForVehicleAndPark(Vehicle vehicle) {
        ParkingSlot parkingSlot = null;

        for (ParkingFloor floor : parkingFloors) {
            parkingSlot = floor.getRelevantSlotForVehicleAndPark(vehicle);
            if (parkingSlot != null) {
                break;
            }
        }
        return parkingSlot;
    }
}

package com.design.lld.parkinglot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Ticket {
    private String ticketNumber;
    private ParkingSlot parkingSlot;
    private Vehicle vehicle;
    private long startTime;
    private long endTime;

    public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot) {
        return Ticket.builder()
                .parkingSlot(parkingSlot)
                .startTime(System.currentTimeMillis())
                .vehicle(vehicle)
                .ticketNumber(vehicle.getVehicleNumber() + System.currentTimeMillis())
                .build();
    }
}

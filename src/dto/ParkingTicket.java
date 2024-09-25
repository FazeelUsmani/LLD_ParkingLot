package dto;

import dto.parkingSpot.ParkingSpot;
import dto.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingTicket {
    private static final AtomicInteger ticketNumber = new AtomicInteger();
    private int id;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime timeStamp;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.id = ticketNumber.incrementAndGet();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.timeStamp = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}

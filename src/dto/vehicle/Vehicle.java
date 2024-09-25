package dto.vehicle;

import enums.ParkingSpotEnum;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Vehicle {
    private static final AtomicInteger idGenerator = new AtomicInteger();
    private int id;
    private ParkingSpotEnum parkingSpotEnum;

    public Vehicle(ParkingSpotEnum parkingSpotEnum) {
        this.id = idGenerator.incrementAndGet();
        this.parkingSpotEnum = parkingSpotEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ParkingSpotEnum getParkingSpotEnum() {
        return parkingSpotEnum;
    }

    public void setParkingSpotEnum(ParkingSpotEnum parkingSpot) {
        this.parkingSpotEnum = parkingSpot;
    }

}

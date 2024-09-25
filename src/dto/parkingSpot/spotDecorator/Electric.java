package dto.parkingSpot.spotDecorator;

import dto.parkingSpot.ParkingSpot;

public class Electric extends SpotDecorator {

    public Electric(ParkingSpot parkingSpot) {
        super(parkingSpot);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingSpot.cost(parkingHours) + 50;
    }
}

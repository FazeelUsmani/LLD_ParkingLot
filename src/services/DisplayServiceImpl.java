package services;

import dto.DisplayBoard;
import enums.ParkingSpotEnum;
import interfaces.DisplayService;

public class DisplayServiceImpl implements DisplayService {

    @Override
    public void update(ParkingSpotEnum parkingSpotEnum, int change) {
        int currentCount = DisplayBoard.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        int newCount = currentCount + change;
        DisplayBoard.getInstance().getFreeParkingSpots().replace(parkingSpotEnum, newCount);

    }
}

package services;

import dto.DisplayBoard;
import dto.ParkingEvent;
import enums.ParkingEventType;
import enums.ParkingSpotEnum;
import interfaces.DisplayService;
import interfaces.Observer;

public class DisplayServiceImpl implements DisplayService, Observer {

    /* Removing this as we added the Observer pattern here
    @Override
    public void update(ParkingSpotEnum parkingSpotEnum, int change) {
        int currentCount = DisplayBoard.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        int newCount = currentCount + change;
        DisplayBoard.getInstance().getFreeParkingSpots().replace(parkingSpotEnum, newCount);
    }
    */

    @Override
    public void update(ParkingEvent event) {
        int currentCount = DisplayBoard.getInstance().getFreeParkingSpots().get(event.getParkingSpotEnum());
        int change = 0;
        if (event.getEventType().equals(ParkingEventType.ENTRY)) {
            change = -1;
        }
        else {
            change = 1;
        }
        int newCount = currentCount + change;
        DisplayBoard.getInstance().getFreeParkingSpots().replace(event.getParkingSpotEnum(), newCount);
        return;
    }

    public void update(ParkingSpotEnum parkingSpotEnum, int change) {
        Integer currentCount = DisplayBoard.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if (currentCount == null) {
            currentCount = 0;
        }
        int newCount = currentCount + change;
        DisplayBoard.getInstance().getFreeParkingSpots().replace(parkingSpotEnum, newCount);
    }
}

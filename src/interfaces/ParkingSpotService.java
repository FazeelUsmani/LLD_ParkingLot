package interfaces;

import dto.parkingSpot.ParkingSpot;
import enums.ParkingSpotEnum;

public interface ParkingSpotService {
    ParkingSpot create(ParkingSpotEnum parkingSpotEnum, int floor) throws NoSuchMethodException;
}

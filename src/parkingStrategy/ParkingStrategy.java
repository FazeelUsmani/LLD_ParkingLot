package parkingStrategy;

import dto.parkingSpot.ParkingSpot;
import enums.ParkingSpotEnum;
import exceptions.SpotNotFoundException;

public interface ParkingStrategy {
    ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException;
}

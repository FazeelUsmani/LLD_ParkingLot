package parkingStrategy;

import dto.ParkingLot;
import dto.parkingSpot.ParkingSpot;
import enums.ParkingSpotEnum;
import exceptions.SpotNotFoundException;

import java.util.List;

public class FarthestFirstParkingStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException {
        List<ParkingSpot> parkingSpots = ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if (parkingSpots.isEmpty()) {
            throw new SpotNotFoundException("Spot not found in Farthest first strategy.");
        }
        return parkingSpots.get(parkingSpots.size() - 1);
    }
}

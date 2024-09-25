package services;

import dto.ParkingLot;
import dto.parkingSpot.ParkingSpot;
import enums.ParkingSpotEnum;
import interfaces.DisplayService;
import interfaces.ParkingSpotService;

import java.lang.reflect.InvocationTargetException;

public class ParkingSpotServiceImpl implements ParkingSpotService {

    DisplayService displayService = new DisplayServiceImpl();

    @Override
    public ParkingSpot create(ParkingSpotEnum parkingSpotEnum, int floor) {
        try {
            ParkingSpot parkingSpot = (ParkingSpot) parkingSpotEnum.getParkingSpot().getConstructor(Integer.class).newInstance(floor);
            ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum).add(parkingSpot);
            displayService.update(parkingSpotEnum, 1);
            return parkingSpot;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}

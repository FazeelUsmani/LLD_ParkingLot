package services;

import dto.ParkingLot;
import dto.ParkingTicket;
import dto.parkingSpot.ParkingSpot;
import dto.vehicle.Vehicle;
import enums.ParkingSpotEnum;
import exceptions.InvalidTicketException;
import exceptions.SpotNotFoundException;
import interfaces.DisplayService;
import interfaces.ParkingService;
import parkingStrategy.ParkingStrategy;

import java.util.List;

public class ParkingServiceImpl implements ParkingService {

    ParkingStrategy parkingStrategy;
    ParkingLot parkingLot;
    DisplayService displayService;

    public ParkingServiceImpl(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
        parkingLot = ParkingLot.getInstance();
        displayService = new DisplayServiceImpl();
    }

    @Override
    public ParkingTicket entry(Vehicle vehicle) {
        ParkingSpotEnum parkingSpotEnum = vehicle.getParkingSpotEnum();
        List<ParkingSpot> freeParkingSpots = parkingLot.getFreeParkingSpots().get(parkingSpotEnum);
        List<ParkingSpot> occupiedParkingSpots = parkingLot.getOccupiedParkingSpots().get(parkingSpotEnum);

        try {
            ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(parkingSpotEnum);
            if (parkingSpot.isFree()) {
                synchronized (parkingSpot) {
                    if (parkingSpot.isFree()) {
                        parkingSpot.setFree(false);
                        freeParkingSpots.remove(parkingSpot);
                        occupiedParkingSpots.add(parkingSpot);
                        ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSpot);
                        displayService.update(parkingSpotEnum, -1);
                        return parkingTicket;
                    }
                    entry(vehicle);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private void addParkingSpotInFreeList(List<ParkingSpot> parkingSpots, ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
    }

    @Override
    public int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException {

        if(parkingTicket.getVehicle().equals(vehicle)) {
            ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
            int amount = parkingSpot.getAmount();
            parkingSpot.setFree(true);
            parkingLot.getOccupiedParkingSpots().get(vehicle.getParkingSpotEnum()).remove(parkingSpot);
            addParkingSpotInFreeList(parkingLot.getFreeParkingSpots().get(vehicle.getParkingSpotEnum()), parkingSpot);
            displayService.update(vehicle.getParkingSpotEnum(), 1);
            return amount;
        }
        else {
            throw new InvalidTicketException("This is an invalid ticket.");
        }


    }
}

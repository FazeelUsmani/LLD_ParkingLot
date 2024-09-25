package interfaces;

import dto.ParkingTicket;
import dto.vehicle.Vehicle;
import exceptions.InvalidTicketException;
import exceptions.SpotNotFoundException;

public interface ParkingService {

    ParkingTicket entry(Vehicle vehicle) throws SpotNotFoundException;

    int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException;
}

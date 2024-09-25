package interfaces;

import dto.ParkingTicket;
import dto.vehicle.Vehicle;
import exceptions.InvalidTicketException;

public interface ParkingService {

    ParkingTicket entry(Vehicle vehicle);

    void exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException;
}

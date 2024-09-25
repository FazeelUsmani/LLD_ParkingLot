import dto.ParkingLot;
import dto.ParkingTicket;
import dto.parkingSpot.ParkingSpot;
import dto.vehicle.Car;
import dto.vehicle.Vehicle;
import enums.ParkingSpotEnum;
import exceptions.InvalidTicketException;
import exceptions.SpotNotFoundException;
import interfaces.ParkingSpotService;
import interfaces.PaymentService;
import parkingStrategy.FarthestFirstParkingStrategy;
import paymentMethods.PaymentMethod;
import services.ParkingServiceImpl;
import services.ParkingSpotServiceImpl;
import services.PaymentServiceImpl;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, SpotNotFoundException, InvalidTicketException {

        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingSpotService parkingSpotService = new ParkingSpotServiceImpl();

        ParkingSpot a1 = parkingSpotService.create(ParkingSpotEnum.COMPACT, 0);
        ParkingSpot a2 = parkingSpotService.create(ParkingSpotEnum.COMPACT, 0);

        ParkingSpot b1 = parkingSpotService.create(ParkingSpotEnum.LARGE, 0);
        ParkingSpot b2 = parkingSpotService.create(ParkingSpotEnum.LARGE, 0);

        ParkingSpot c1 = parkingSpotService.create(ParkingSpotEnum.MINI, 0);
        ParkingSpot c2 = parkingSpotService.create(ParkingSpotEnum.MINI, 0);

        Vehicle v1 = new Car();
        Vehicle v2 = new Car();
        Vehicle v3 = new Car();

        ParkingServiceImpl parkingService = new ParkingServiceImpl(new FarthestFirstParkingStrategy());
        PaymentService paymentService = new PaymentServiceImpl();

        ParkingTicket parkingTicket1 = parkingService.entry(v1);
        System.out.println("Parking Ticket 1 : " + parkingTicket1);
        System.out.println("Parking Ticket 1 with vehicle id: " + parkingTicket1.getVehicle().getId());
        System.out.println(parkingTicket1.getVehicle().equals(v1));

        ParkingTicket parkingTicket2 = parkingService.entry(v2);
        parkingService.addWash(parkingTicket2);
        System.out.println("Parking Ticket 2 : " + parkingTicket2);
        System.out.println("Parking Ticket 2 with vehicle id: " + parkingTicket2.getVehicle().getId());
        System.out.println(parkingTicket2.getVehicle().equals(v2));

        try {
            parkingService.exit(parkingTicket2, v2);
            int cost = parkingTicket2.getParkingSpot().cost(parkingTicket2.getParkingHours());
            System.out.println("cost: " + cost);
            paymentService.acceptCash(cost);
        } catch (InvalidTicketException e) {
            throw new RuntimeException(e);
        }
    }
}
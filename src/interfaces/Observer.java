package interfaces;

import dto.ParkingEvent;

public interface Observer {
    void update(ParkingEvent event);

}

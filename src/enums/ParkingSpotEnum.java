package enums;

import dto.parkingSpot.Compact;
import dto.parkingSpot.Large;
import dto.parkingSpot.Mini;

public enum ParkingSpotEnum {
    COMPACT(Compact.class),
    MINI(Mini .class),
    LARGE(Large.class);

    private Class parkingSpot;

    ParkingSpotEnum(Class parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Class getParkingSpot() {
        return parkingSpot;
    }


}

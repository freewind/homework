package homework3;

import java.util.Arrays;
import java.util.List;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public String park(Car car) {
        for (ParkingLot lot : parkingLots) {
            String ticket = lot.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        return null;
    }
}

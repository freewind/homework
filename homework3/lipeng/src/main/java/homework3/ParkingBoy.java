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
}

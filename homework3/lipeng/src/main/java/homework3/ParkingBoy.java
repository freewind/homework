package homework3;

import java.util.Arrays;
import java.util.List;

public class ParkingBoy {

    protected final List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
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

    public Car unpark(String ticket) {
        for (ParkingLot lot : parkingLots) {
            Car car = lot.unpark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }
}

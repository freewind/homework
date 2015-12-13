package homework3;

import java.util.List;

public class ParkingManager implements Parker {
    private final List<Parker> parkers;

    public ParkingManager(List<Parker> parkers) {
        this.parkers = parkers;
    }

    public String park(Car car) {
        for (Parker parker : parkers) {
            String ticket = parker.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        return null;
    }

    public Car unpark(String ticket) {
        for (Parker parker : parkers) {
            Car car = parker.unpark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

}

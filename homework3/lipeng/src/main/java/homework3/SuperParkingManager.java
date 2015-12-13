package homework3;

import java.util.List;

public class SuperParkingManager {
    private List<ParkingManager> managers;

    public SuperParkingManager(List<ParkingManager> managers) {
        this.managers = managers;
    }

    public String park(Car car) {
        for (ParkingManager manager : managers) {
            String ticket = manager.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        return null;
    }

    public Car unpark(String ticket) {
        for (ParkingManager manager : managers) {
            Car car = manager.unpark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }
}

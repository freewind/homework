package homework3;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {
    private List<ParkingBoy> boys;
    private List<ParkingManager> managers;

    private ParkingManager(List<ParkingBoy> boys, List<ParkingManager> managers) {
        this.boys = boys;
        this.managers = managers;
    }

    public static ParkingManager withBoys(List<ParkingBoy> boys) {
        return new ParkingManager(boys, new ArrayList<>());
    }


    public String park(Car car) {
        for (ParkingBoy boy : boys) {
            String park = boy.park(car);
            if (park != null) {
                return park;
            }
        }
        for (ParkingManager manager : managers) {
            String park = manager.park(car);
            if (park != null) {
                return park;
            }
        }
        return null;
    }

    public Car unpark(String ticket) {
        for (ParkingBoy boy : boys) {
            Car car = boy.unpark(ticket);
            if (car != null) {
                return car;
            }
        }
        for (ParkingManager manager : managers) {
            Car car = manager.unpark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    public static ParkingManager withManagers(List<ParkingManager> ts) {
        return new ParkingManager(new ArrayList<>(), ts);
    }
}

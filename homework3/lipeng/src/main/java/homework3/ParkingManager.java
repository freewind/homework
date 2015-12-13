package homework3;

import java.util.List;

public class ParkingManager {
    private List<ParkingBoy> boys;

    public ParkingManager(List<ParkingBoy> boys) {
        this.boys = boys;
    }

    public String park(Car car) {
        for (ParkingBoy boy : boys) {
            String park = boy.park(car);
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
        return null;
    }

}

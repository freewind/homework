package homework3;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int capacity;
    private final List<Car> cars = new ArrayList<Car>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public void park(Car car) {
        if (getAvailableSpaces() > 0) {
            this.cars.add(car);
        }
    }

    public int getAvailableSpaces() {
        return capacity - cars.size();
    }
}

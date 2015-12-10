package homework3;

import java.util.*;

public class ParkingLot {
    private final int capacity;
    private final Map<String, Car> cars = new HashMap();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public String park(Car car) {
        if (getAvailableSpaces() > 0) {
            String ticket = newTicket();
            this.cars.put(ticket, car);
            return ticket;
        } else {
            return null;
        }
    }

    private String newTicket() {
        return UUID.randomUUID().toString();
    }

    public int getAvailableSpaces() {
        return capacity - cars.size();
    }

    public Car unpark(String ticket) {
        return cars.get(ticket);
    }
}

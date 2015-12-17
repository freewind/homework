package homework3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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

    public String reportInfo() {
        String parkersReport = parkers.stream()
                .flatMap(parker -> Arrays.stream(parker.reportInfo().split("\n")).map(line -> "-- " + line)).reduce((a, b) -> a + "\n" + b).get();
        return "ParkingManager\n" + parkersReport;
    }

}

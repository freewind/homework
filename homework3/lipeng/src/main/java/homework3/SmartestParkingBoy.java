package homework3;

import java.util.ArrayList;
import java.util.List;

public class SmartestParkingBoy extends ParkingBoy {

    public SmartestParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    public String park(Car car) {
        List<ParkingLot> copy = new ArrayList<>(parkingLots);
        copy.sort((o1, o2) -> {
            double emptyRatio2 = o2.getEmptyRatio();
            double emptyRatio1 = o1.getEmptyRatio();
            if (emptyRatio2 > emptyRatio1) {
                return 1;
            } else if (emptyRatio2 == emptyRatio1) {
                return 0;
            } else {
                return -1;
            }
        });
        return copy.get(0).park(car);
    }
}

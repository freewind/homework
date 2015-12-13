package homework3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SmarterParkingBoy extends ParkingBoy {

    public SmarterParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    public String park(Car car) {
        ArrayList<ParkingLot> copy = new ArrayList<>(parkingLots);
        copy.sort((o1, o2) -> o2.getAvailableSpaces() - o1.getAvailableSpaces());
        return copy.get(0).park(car);
    }

}

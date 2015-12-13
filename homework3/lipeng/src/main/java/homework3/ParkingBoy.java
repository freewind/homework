package homework3;

import homework3.finding_policy.FindingParkingLotPolicy;

import java.util.Arrays;
import java.util.List;

public class ParkingBoy {

    protected final List<ParkingLot> parkingLots;
    private final FindingParkingLotPolicy findingParkingLotPolicy;

    public ParkingBoy(FindingParkingLotPolicy policy, ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
        this.findingParkingLotPolicy = policy;
    }

    public String park(Car car) {
        ParkingLot best = findingParkingLotPolicy.findBestParkingLot(parkingLots);
        return best.park(car);
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

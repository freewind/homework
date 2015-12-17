package homework3;

import homework3.finding_policy.FindingParkingLotPolicy;

import java.util.Arrays;
import java.util.List;

public class ParkingBoy implements Parker {

    protected final List<ParkingLot> parkingLots;
    private final FindingParkingLotPolicy findingParkingLotPolicy;

    public ParkingBoy(FindingParkingLotPolicy policy, ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
        this.findingParkingLotPolicy = policy;
    }

    @Override
    public String park(Car car) {
        ParkingLot best = findingParkingLotPolicy.findBestParkingLot(parkingLots);
        return best.park(car);
    }

    @Override
    public Car unpark(String ticket) {
        for (ParkingLot lot : parkingLots) {
            Car car = lot.unpark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    @Override
    public String reportInfo() {
        Integer allAvailable = parkingLots.stream().map(ParkingLot::getAvailableSpaces).reduce(Integer::sum).get();
        Integer allCapacity = parkingLots.stream().map(ParkingLot::getCapacity).reduce(Integer::sum).get();
        return "ParkingBoy (" + allAvailable.toString() + "/" + allCapacity.toString() + ")";
    }
}

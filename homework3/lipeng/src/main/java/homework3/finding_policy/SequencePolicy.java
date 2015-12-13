package homework3.finding_policy;

import homework3.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class SequencePolicy implements FindingParkingLotPolicy {

    @Override
    public ParkingLot findBestParkingLot(List<ParkingLot> parkingLots) {
        List<ParkingLot> copy = new ArrayList<>(parkingLots);
        return copy.stream().filter(lot -> lot.getAvailableSpaces() > 0).findFirst().orElse(copy.get(0));
    }
}

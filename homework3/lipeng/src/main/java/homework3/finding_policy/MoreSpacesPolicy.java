package homework3.finding_policy;

import homework3.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class MoreSpacesPolicy implements FindingParkingLotPolicy {

    public ParkingLot findBestParkingLot(List<ParkingLot> parkingLots) {
        ArrayList<ParkingLot> copy = new ArrayList<>(parkingLots);
        copy.sort((o1, o2) -> o2.getAvailableSpaces() - o1.getAvailableSpaces());
        return copy.get(0);
    }
}

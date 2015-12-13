package homework3.finding_policy;

import homework3.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class HighestEmptyRatioPolicy implements FindingParkingLotPolicy {

    @Override
    public ParkingLot findBestParkingLot(List<ParkingLot> parkingLots) {
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
        return copy.get(0);

    }
}

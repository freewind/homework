package homework3.finding_policy;

import homework3.ParkingLot;

import java.util.List;

public interface FindingParkingLotPolicy {
    ParkingLot findBestParkingLot(List<ParkingLot> parkingLots);
}

package homework3;

import com.greghaskins.spectrum.Spectrum;
import homework3.finding_policy.SequencePolicy;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static com.greghaskins.spectrum.Spectrum.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Spectrum.class)
public class ParkingReportSpec {

    {

        describe("ParkingBoy", () -> {
            it("可以生成自己的停车场空位信息", () -> {
                ParkingBoy parkingBoy = createParkingBoy(createParkingLot(3, 5), createParkingLot(2, 6));
                assertThat(parkingBoy.reportInfo()).isEqualTo("ParkingBoy (6/11)");
            });
        });

        describe("ParkingManager", () -> {
            describe("只包含ParkingBoy", () -> {
                it("可以生成正确的Report信息", () -> {
                    ParkingBoy parkingBoy1 = createParkingBoy(createParkingLot(3, 5), createParkingLot(2, 6));
                    ParkingBoy parkingBoy2 = createParkingBoy(createParkingLot(3, 4), createParkingLot(2, 3));
                    ParkingManager parkingManager = new ParkingManager(Arrays.asList(parkingBoy1, parkingBoy2));
                    assertThat(parkingManager.reportInfo()).isEqualTo(
                            "ParkingManager\n" +
                                    "-- ParkingBoy (6/11)\n" +
                                    "-- ParkingBoy (2/7)");
                });
            });
            describe("包含ParkingManager和ParkingBoy", () -> {
                it("可以生成正确的Report信息", () -> {
                    ParkingBoy parkingBoy = createParkingBoy(createParkingLot(3, 5), createParkingLot(2, 6));
                    ParkingManager parkingManager = new ParkingManager(Arrays.asList(createParkingBoy(createParkingLot(3, 4), createParkingLot(2, 3))));
                    ParkingManager superParkingManager = new ParkingManager(Arrays.asList(parkingBoy, parkingManager));
                    assertThat(superParkingManager.reportInfo()).isEqualTo(
                            "ParkingManager\n" +
                                    "-- ParkingBoy (6/11)\n" +
                                    "-- ParkingManager\n" +
                                    "-- -- ParkingBoy (2/7)");
                });
            });
        });

    }

    private ParkingBoy createParkingBoy(ParkingLot... parkingLots) {
        return new ParkingBoy(new SequencePolicy(), parkingLots);
    }

    private ParkingLot createParkingLot(int cars, int capacity) {
        ParkingLot lot = new ParkingLot(capacity);
        for (int i = 0; i < cars; i++) {
            lot.park(new Car());
        }
        return lot;
    }
}

package homework3;

import com.greghaskins.spectrum.Spectrum;
import homework3.finding_policy.SequencePolicy;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static com.greghaskins.spectrum.Spectrum.describe;
import static com.greghaskins.spectrum.Spectrum.it;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Spectrum.class)
public class ParkingManagerWithOtherManagersSpec {

    {

        describe("SuperParkingManager", () -> {
            describe("可以通过管理的ParkingManagers来停车", () -> {
                it("停车成功时,拿到ticket", () -> {
                    Parker parkingManager = new ParkingManager(createNonFullParkingManagers());
                    String ticket = parkingManager.park(new Car());
                    assertThat(ticket).isNotNull();
                });
                it("停车失败时,拿不到ticket", () -> {
                    Parker parkingManager = new ParkingManager(createFullManagers());
                    String ticket = parkingManager.park(new Car());
                    assertThat(ticket).isNull();
                });
            });
            describe("可以通过管理的ParkingManagers来取车", () -> {
                it("如果ticket有效,可以成功取车", () -> {
                    Parker parkingManager = new ParkingManager(createNonFullParkingManagers());
                    Car car = new Car();
                    String ticket = parkingManager.park(car);
                    Car unparked = parkingManager.unpark(ticket);
                    assertThat(unparked).isEqualTo(car);
                });
                it("如果ticket无效,则取车失败", () -> {
                    Parker parkingManager = new ParkingManager(createNonFullParkingManagers());
                    Car unparked = parkingManager.unpark("invalid-ticket");
                    assertThat(unparked).isNull();
                });
            });
        });

    }

    private List<Parker> createFullManagers() {
        List<Parker> boys = Arrays.asList(
                new ParkingBoy(new SequencePolicy(), new ParkingLot(0)),
                new ParkingBoy(new SequencePolicy(), new ParkingLot(0)));
        return Arrays.asList(new ParkingManager(boys));
    }

    private List<Parker> createNonFullParkingManagers() {
        List<Parker> boys = Arrays.asList(
                new ParkingBoy(new SequencePolicy(), new ParkingLot(3)),
                new ParkingBoy(new SequencePolicy(), new ParkingLot(2)));
        return Arrays.asList(new ParkingManager(boys));
    }
}

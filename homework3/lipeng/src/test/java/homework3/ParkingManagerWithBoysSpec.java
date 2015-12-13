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
public class ParkingManagerWithBoysSpec {

    {

        describe("ParkingManager", () -> {
            describe("可以通过管理的parking boys来停车", () -> {
                it("停车成功时,拿到ticket", () -> {
                    List<Parker> boys = createBoysWithNonFullLots();
                    Parker parkingManager = new ParkingManager(boys);
                    String ticket = parkingManager.park(new Car());
                    assertThat(ticket).isNotNull();
                });
                it("停车失败时,拿不到ticket", () -> {
                    List<Parker> boys = createBoysWithFullLots();
                    Parker parkingManager = new ParkingManager(boys);
                    String ticket = parkingManager.park(new Car());
                    assertThat(ticket).isNull();
                });
            });
            describe("可以通过管理的parking boys来取车", () -> {
                it("如果ticket有效,可以成功取车", () -> {
                    List<Parker> boys = createBoysWithNonFullLots();
                    Parker parkingManager = new ParkingManager(boys);
                    Car car = new Car();
                    String ticket = parkingManager.park(car);
                    Car unparked = parkingManager.unpark(ticket);
                    assertThat(unparked).isEqualTo(car);
                });
                it("如果ticket无效,则取车失败", () -> {
                    List<Parker> boys = createBoysWithNonFullLots();
                    Parker parkingManager = new ParkingManager(boys);
                    Car unparked = parkingManager.unpark("invalid-ticket");
                    assertThat(unparked).isNull();
                });
            });
        });

    }

    private List<Parker> createBoysWithFullLots() {
        return Arrays.asList(
                new ParkingBoy(new SequencePolicy(), new ParkingLot(0)),
                new ParkingBoy(new SequencePolicy(), new ParkingLot(0)));
    }

    private List<Parker> createBoysWithNonFullLots() {
        return Arrays.asList(
                new ParkingBoy(new SequencePolicy(), new ParkingLot(3)),
                new ParkingBoy(new SequencePolicy(), new ParkingLot(2)));
    }
}

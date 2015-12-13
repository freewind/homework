package homework3;

import com.greghaskins.spectrum.Spectrum;
import homework3.finding_policy.SequencePolicy;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static com.greghaskins.spectrum.Spectrum.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Spectrum.class)
public class ParkingManagerSpec {

    {

        describe("manager", () -> {
            describe("可以通过boys来停车", () -> {
                it("停车成功时,拿到ticket", () -> {
                    List<ParkingBoy> boys = Arrays.asList(
                            new ParkingBoy(new SequencePolicy(), new ParkingLot(3)),
                            new ParkingBoy(new SequencePolicy(), new ParkingLot(2)));
                    ParkingManager parkingManager = ParkingManager.withBoys(boys);
                    String ticket = parkingManager.park(new Car());
                    assertThat(ticket).isNotNull();
                });
                it("停车失败时,拿不到ticket", () -> {
                    List<ParkingBoy> boys = Arrays.asList(
                            new ParkingBoy(new SequencePolicy(), new ParkingLot(0)),
                            new ParkingBoy(new SequencePolicy(), new ParkingLot(0)));
                    ParkingManager parkingManager = ParkingManager.withBoys(boys);
                    String ticket = parkingManager.park(new Car());
                    assertThat(ticket).isNull();
                });
            });
            describe("可以通过boys来取车", () -> {
                it("如果ticket有效,可以成功取车", () -> {
                    List<ParkingBoy> boys = Arrays.asList(
                            new ParkingBoy(new SequencePolicy(), new ParkingLot(3)),
                            new ParkingBoy(new SequencePolicy(), new ParkingLot(2)));
                    ParkingManager parkingManager = ParkingManager.withBoys(boys);
                    Car car = new Car();
                    String ticket = parkingManager.park(car);
                    Car unparked = parkingManager.unpark(ticket);
                    assertThat(unparked).isEqualTo(car);
                });
                it("如果ticket无效,则取车失败", () -> {
                    List<ParkingBoy> boys = Arrays.asList(
                            new ParkingBoy(new SequencePolicy(), new ParkingLot(3)),
                            new ParkingBoy(new SequencePolicy(), new ParkingLot(2)));
                    ParkingManager parkingManager = ParkingManager.withBoys(boys);
                    Car unparked = parkingManager.unpark("invalid-ticket");
                    assertThat(unparked).isNull();
                });
            });
        });

    }
}

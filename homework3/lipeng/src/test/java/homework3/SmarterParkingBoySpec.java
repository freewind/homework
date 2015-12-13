package homework3;

import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;

import static com.greghaskins.spectrum.Spectrum.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Spectrum.class)
public class SmarterParkingBoySpec {

    private ParkingLot parkingLot1;

    private ParkingLot parkingLot2;

    private SmarterParkingBoy boy;

    private Car car;

    {
        beforeEach(() -> {
            parkingLot1 = new ParkingLot(1);
            parkingLot2 = new ParkingLot(2);
            boy = new SmarterParkingBoy(parkingLot1, parkingLot2);
            car = new Car();
        });

        describe("parking", () -> {
            it("should do park into the parking lot which has more spaces", () -> {
                boy.park(car);
                assertThat(parkingLot1.getAvailableSpaces()).isEqualTo(1);
                assertThat(parkingLot2.getAvailableSpaces()).isEqualTo(1);
            });
        });

        describe("取车", () -> {
            it("可以帮忙取车", () -> {
                String ticket = boy.park(car);
                Car car = boy.unpark(ticket);
                assertThat(car).isNotNull();
            });
        });
    }
}

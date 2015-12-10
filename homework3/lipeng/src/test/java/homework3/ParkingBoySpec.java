package homework3;

import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;

import static com.greghaskins.spectrum.Spectrum.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Spectrum.class)
public class ParkingBoySpec {

    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;
    private ParkingBoy boy;
    private Car car;

    {
        beforeEach(() -> {
            parkingLot1 = new ParkingLot(3);
            parkingLot2 = new ParkingLot(2);
            boy = new ParkingBoy(parkingLot1, parkingLot2);
            car = new Car();
        });

        describe("管理员", () -> {
            it("可以管理多个停车场", () -> {
                assertThat(boy.getParkingLots()).containsExactly(parkingLot1, parkingLot2);
            });
            it("可以帮忙停车", () -> {
                String ticket = boy.park(car);
                assertThat(ticket).isNotNull();
            });
            it("如果没有空位,则停不了", () -> {
                boy = new ParkingBoy(new ParkingLot(0));
                String ticket = boy.park(car);
                assertThat(ticket).isNull();
            });
            it("可以帮忙取车", () -> {
                String ticket = boy.park(car);
                Car car = boy.unpark(ticket);
                assertThat(car).isNotNull();
            });
        });

    }
}

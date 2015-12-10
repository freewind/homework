package homework3;

import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;

import static com.greghaskins.spectrum.Spectrum.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Spectrum.class)
public class ParkingLotSpec {

    {

        describe("停车场", () -> {
            describe("停车", () -> {
                it("只要没满可以停车", () -> {
                    ParkingLot parkingLot = new ParkingLot(2);
                    parkingLot.park(new Car());
                    assertThat(parkingLot.getAvailableSpaces()).isEqualTo(1);
                });
                it("满了就不能停了", () -> {
                    ParkingLot parkingLot = new ParkingLot(1);
                    parkingLot.park(new Car());
                    parkingLot.park(new Car());
                    assertThat(parkingLot.getAvailableSpaces()).isEqualTo(0);
                });
            });
            describe("取车", () -> {
                ParkingLot parkingLot = new ParkingLot(2);
                Car car = new Car();
                String ticket = parkingLot.park(car);
                Car returnedCar = parkingLot.unpark(ticket);
                assertThat(returnedCar).isEqualTo(car);
            });
        });

    }
}

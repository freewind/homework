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
                    String ticket = parkingLot.park(new Car());
                    assertThat(ticket).isNotNull();
                    assertThat(parkingLot.getAvailableSpaces()).isEqualTo(1);
                });
                it("满了就不能停了", () -> {
                    ParkingLot parkingLot = new ParkingLot(1);
                    parkingLot.park(new Car());
                    String ticket = parkingLot.park(new Car());
                    assertThat(ticket).isNull();
                    assertThat(parkingLot.getAvailableSpaces()).isEqualTo(0);
                });
            });
            describe("取车", () -> {
                it("可以取回自己的车", () -> {
                    ParkingLot parkingLot = new ParkingLot(2);
                    Car car = new Car();
                    String ticket = parkingLot.park(car);
                    Car returnedCar = parkingLot.unpark(ticket);
                    assertThat(returnedCar).isEqualTo(car);
                });
                it("无票不能取车", () -> {
                    ParkingLot parkingLot = new ParkingLot(2);
                    Car returnedCar = parkingLot.unpark(null);
                    assertThat(returnedCar).isNull();
                });
                it("无效票不能取车", () -> {
                    ParkingLot parkingLot = new ParkingLot(2);
                    Car returnedCar = parkingLot.unpark("invalid-ticket");
                    assertThat(returnedCar).isNull();
                });
            });
        });

    }
}

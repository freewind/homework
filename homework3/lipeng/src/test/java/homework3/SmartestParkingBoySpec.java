package homework3;

import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;

import static com.greghaskins.spectrum.Spectrum.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Spectrum.class)
public class SmartestParkingBoySpec {

    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;
    private SmartestParkingBoy boy;

    {

        beforeEach(() -> {
            parkingLot1 = new ParkingLot(6);
            parkingLot2 = new ParkingLot(10);
            boy = new SmartestParkingBoy(parkingLot1, parkingLot2);

            parkCars(parkingLot1, 2);
            parkCars(parkingLot2, 5);
        });

        describe("最聪明的停车小弟", () -> {
            it("会把车停到空置率(空/总)最高的停车场", () -> {
                boy.park(new Car());
                assertThat(parkingLot1.getAvailableSpaces()).isEqualTo(3);
                assertThat(parkingLot2.getAvailableSpaces()).isEqualTo(5);
            });
        });

    }

    private void parkCars(ParkingLot parkingLot, int cars) {
        for (int i = 0; i < cars; i++) {
            parkingLot.park(new Car());
        }
    }
}

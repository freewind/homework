package homework3;

import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;

import static com.greghaskins.spectrum.Spectrum.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Spectrum.class)
public class ParkingLotSpec {

    {

        describe("停车场", () -> {
            it("只要没满可以停车", () -> {
                ParkingLot parkingLot = new ParkingLot(2);
                parkingLot.park(new Car());
                assertThat(parkingLot.getAvailableSpaces()).isEqualTo(1);
            });
        });

    }
}

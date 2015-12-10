package homework3;

import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;

import static com.greghaskins.spectrum.Spectrum.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Spectrum.class)
public class ParkingBoySpec {

    {

        describe("管理员", () -> {
            it("可以管理多个停车场", () -> {
                ParkingLot parkingLot1 = new ParkingLot(3);
                ParkingLot parkingLot2 = new ParkingLot(2);
                ParkingBoy boy = new ParkingBoy(parkingLot1, parkingLot2);
                assertThat(boy.getParkingLots()).containsExactly(parkingLot1, parkingLot2);
            });
        });

    }
}

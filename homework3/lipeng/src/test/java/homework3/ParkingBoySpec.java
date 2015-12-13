package homework3;

import com.greghaskins.spectrum.Spectrum;
import homework3.finding_policy.SequencePolicy;
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
            boy = new ParkingBoy(new SequencePolicy(), parkingLot1, parkingLot2);
            car = new Car();
        });

        describe("管理员", () -> {
            describe("停车", () -> {
                it("可以帮忙停车", () -> {
                    String ticket = boy.park(car);
                    assertThat(ticket).isNotNull();
                });
                it("如果没有空位,则停不了", () -> {
                    boy = new ParkingBoy(new SequencePolicy(), new ParkingLot(0));
                    String ticket = boy.park(car);
                    assertThat(ticket).isNull();
                });
                describe("停车时,会采用'依次停满'的策略", () -> {
                    it("如果第一个停车场没满,会停在第一个", () -> {
                        parkingLot1 = new ParkingLot(2);
                        parkingLot2 = new ParkingLot(2);
                        boy = new ParkingBoy(new SequencePolicy(), parkingLot1, parkingLot2);

                        boy.park(new Car());
                        boy.park(new Car());

                        assertThat(parkingLot1.getAvailableSpaces()).isEqualTo(0);
                        assertThat(parkingLot2.getAvailableSpaces()).isEqualTo(2);
                    });
                    it("如果第一个停车场停满了,才会停在第二个", () -> {
                        parkingLot1 = new ParkingLot(2);
                        parkingLot2 = new ParkingLot(2);
                        boy = new ParkingBoy(new SequencePolicy(), parkingLot1, parkingLot2);

                        boy.park(new Car());
                        boy.park(new Car());
                        boy.park(new Car());

                        assertThat(parkingLot1.getAvailableSpaces()).isEqualTo(0);
                        assertThat(parkingLot2.getAvailableSpaces()).isEqualTo(1);
                    });
                });
            });
            describe("取车", () -> {
                it("可以帮忙取车", () -> {
                    String ticket = boy.park(car);
                    Car car = boy.unpark(ticket);
                    assertThat(car).isNotNull();
                });
                it("如果没票则不能取车", () -> {
                    String nonTicket = null;
                    Car car = boy.unpark(nonTicket);
                    assertThat(car).isNull();
                });
                it("如果票不对,则不能取车", () -> {
                    Car car = boy.unpark("invalid-ticket");
                    assertThat(car).isNull();
                });
            });
        });

    }
}

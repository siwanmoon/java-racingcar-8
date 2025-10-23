package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.message.ErrorMessage.RACINGCAR_NAME_LENGTH_OVERFLOW;

public class CarTest {

    @Test
    void 자동차명_길이_초과테스트() {
        String test1Carname = "pobi";
        String test2Carname = "abcde";
        String test3Carname = "abcdef";

        Car testResult1 = new Car(test1Carname, 0);
        Car testResult2 = new Car(test2Carname, 0);

        assertEquals(testResult1, new Car(test1Carname, 0));
        assertEquals(testResult2, new Car(test2Carname, 0));
        assertThatThrownBy(() -> new Car(test3Carname, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RACINGCAR_NAME_LENGTH_OVERFLOW.getMessage());
    }

    @Test
    void 자동차_전진_테스트() {
        String testCarname = "pobi";
        int test1CarStartPosition = 0;
        int test2CarStartPosition = 100;
        int test3CarStartPosition = 12345;
        int test1CarResultPosition = 1;
        int test2CarResultPosition = 101;
        int test3CarResultPosition = 12346;

        Car car1 = new Car(testCarname, test1CarStartPosition);
        Car car2 = new Car(testCarname, test2CarStartPosition);
        Car car3 = new Car(testCarname, test3CarStartPosition);

        car1.moveForward();
        car2.moveForward();
        car3.moveForward();

        assertEquals(new Car(testCarname, test1CarResultPosition), car1);
        assertEquals(new Car(testCarname, test2CarResultPosition), car2);
        assertEquals(new Car(testCarname, test3CarResultPosition), car3);
    }
}

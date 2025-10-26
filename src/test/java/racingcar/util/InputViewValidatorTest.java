package racingcar.util;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.message.ErrorMessage.RACINGCAR_NAME_NOT_UNIQUE;
import static racingcar.common.message.ErrorMessage.RACINGCAR_NAME_BLANCK;
import static racingcar.common.message.ErrorMessage.RACINGCAR_NAME_NOT_ENGLISH;
import static racingcar.common.message.ErrorMessage.RACINGCAR_ATTEMPT_BLANK;
import static racingcar.common.message.ErrorMessage.RACINGCAR_ATTEMPT_NOT_NUBER;

import racingcar.model.Car;

public class InputViewValidatorTest {

    @Test
    void 자동차이름_중복입력_테스트() {

        InputValidator inputValidator = new InputValidator();
        String test1 = "pobi,woni,jun";
        String test2 = "pobi, woni, jun";
        String test3 = "pobi, woni, pobi";

        List<Car> testResult = List.of(
                new Car("pobi", 0),
                new Car("woni", 0),
                new Car("jun", 0)
        );

        assertEquals(testResult, inputValidator.racingcars(test1));
        assertEquals(testResult, inputValidator.racingcars(test2));
        assertThatThrownBy(() -> inputValidator.racingcars(test3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RACINGCAR_NAME_NOT_UNIQUE.getMessage());
    }

    @Test
    void 자동차이름_공백_테스트() {

        InputValidator inputValidator = new InputValidator();
        String test1 = "pobi,woni,jun";
        String test2 = "pobi,, jun";
        String test3 = "pobi,  , jun";

        List<Car> testResult = List.of(
                new Car("pobi", 0),
                new Car("woni", 0),
                new Car("jun", 0)
        );

        assertEquals(testResult, inputValidator.racingcars(test1));
        assertThatThrownBy(() -> inputValidator.racingcars(test2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RACINGCAR_NAME_BLANCK.getMessage());
        assertThatThrownBy(() -> inputValidator.racingcars(test3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RACINGCAR_NAME_BLANCK.getMessage());
    }

    @Test
    void 자동차이름_영문자_제외_문자입력_테스트() {

        InputValidator inputValidator = new InputValidator();
        String test1 = "pobi,woni,jun";
        String test2 = "pobi, w5ekj, jun";
        String test3 = "pobi, $55.d , jun";

        List<Car> testResult = List.of(
                new Car("pobi", 0),
                new Car("woni", 0),
                new Car("jun", 0)
        );

        assertEquals(testResult, inputValidator.racingcars(test1));
        assertThatThrownBy(() -> inputValidator.racingcars(test2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RACINGCAR_NAME_NOT_ENGLISH.getMessage());
        assertThatThrownBy(() -> inputValidator.racingcars(test3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RACINGCAR_NAME_NOT_ENGLISH.getMessage());
    }

    @Test
    void 시행횟수_미입력_테스트() {

        InputValidator inputValidator = new InputValidator();
        String test1 = " 5 ";
        String test2 = "";
        String test3 = "\n";

        assertEquals(5, inputValidator.attemptNumber(test1));
        assertThatThrownBy(() -> inputValidator.attemptNumber(test2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RACINGCAR_ATTEMPT_BLANK.getMessage());
        assertThatThrownBy(() -> inputValidator.attemptNumber(test3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RACINGCAR_ATTEMPT_BLANK.getMessage());
    }

    @Test
    void 시행횟수_숫자_제외_문자입력_테스트() {

        InputValidator inputValidator = new InputValidator();
        String test1 = " 5";
        String test2 = "##";
        String test3 = "5.$%";

        assertEquals(5, inputValidator.attemptNumber(test1));
        assertThatThrownBy(() -> inputValidator.attemptNumber(test2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RACINGCAR_ATTEMPT_NOT_NUBER.getMessage());
        assertThatThrownBy(() -> inputValidator.attemptNumber(test3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RACINGCAR_ATTEMPT_NOT_NUBER.getMessage());
    }
}

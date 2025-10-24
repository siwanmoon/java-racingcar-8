package racingcar.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.service.RacingGame;
import racingcar.model.service.impl.RacingGameImpl;

public class RacingGameImplTest {

    @Test
    void 경기가_아직_끝나지_않았는지_확인_테스트() {
        List<Car> carsNotFinished = List.of(new Car("pobi", 5));
        RacingGame game = new RacingGameImpl(carsNotFinished, 5);
        assertTrue(game.notFinished());
    }

    @Test
    void 남은_시도룃수가_0일때_종료되는지_확인_테스트() {
        List<Car> cars = List.of(new Car("pobi", 5));
        RacingGame game = new RacingGameImpl(cars, 0);
        assertFalse(game.notFinished());
    }

    @Test
    void 결승선_통과시_종료되는지_확인_테스트() {
        List<Car> carsFinished = List.of(new Car("pobi", 50), new Car("woni", 100));
        RacingGame game = new RacingGameImpl(carsFinished, 5);
        assertFalse(game.notFinished());
    }
}

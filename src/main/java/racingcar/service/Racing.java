package racingcar.service;

import java.util.List;
import racingcar.model.Car;

public interface Racing {

    List<List<Car>> emulator(List<Car> racingcarNames, int racingAttemptNumber);
}

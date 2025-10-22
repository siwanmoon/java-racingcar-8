package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.Racing;
import racingcar.service.impl.RacingImpl;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();
        Racing racingService = new RacingImpl();
        RacingController racingController = new RacingController(input, output, racingService);

        racingController.run();
    }
}

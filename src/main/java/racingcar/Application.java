package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        Output output = new Output();
        RacingController racingController = new RacingController(input, output);

        racingController.run();
    }
}

package racingcar.controller;

import racingcar.service.Racing;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingController {

    private final Input input;
    private final Output output;
    private final Racing racing;

    public RacingController(Input input, Output output, Racing racing) {
        this.input = input;
        this.output = output;
        this.racing = racing;
    }

    public void run() {
        output.requestRacingcarName();
        String racingcarNames = input.getInput();
        output.requestAttemptNumber();
        String racingAttemptNumberString = input.getInput();
    }
}

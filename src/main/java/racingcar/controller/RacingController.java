package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.service.Racing;
import racingcar.util.InputValidator;
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
        String racingcarNameInput = input.getInput();
        output.requestAttemptNumber();
        String racingAttemptNumberString = input.getInput();

        // input의 유효성검사
        InputValidator inputValidator = new InputValidator();
        List<Car> racingcarNames = inputValidator.racingcars(racingcarNameInput);
        int racingAttemptNumber = inputValidator.attemptNumber(racingAttemptNumberString);

        racing.emulator(racingcarNames, racingAttemptNumber);
    }
}

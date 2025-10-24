package racingcar.controller;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.service.RacingGame;
import racingcar.model.service.impl.RacingGameImpl;
import racingcar.util.InputValidator;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingController {

    private final Input input;
    private final Output output;

    public RacingController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        List<Car> racingcars = requestCarNames();
        int attemptNumbr = requestAttemptNuber();

        RacingGame racingGame = new RacingGameImpl(racingcars, attemptNumbr);
        startRacing(racingGame);
    }

    private List<Car> requestCarNames() {
        output.requestRacingcarName();
        String carNamesInput = input.getInput();
        return InputValidator.racingcars(carNamesInput);
    }

    private int requestAttemptNuber() {
        output.requestAttemptNumber();
        String attemptNumberInput = input.getInput();
        return InputValidator.attemptNumber(attemptNumberInput);
    }

    private void startRacing(RacingGame racingGame) {
        while(racingGame.notFinished()) {
            racingGame.playOneRound();
        }
    }
}

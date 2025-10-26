package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RaceParticipantsDto;
import racingcar.model.service.RacingGame;
import racingcar.model.service.impl.RacingGameImpl;
import racingcar.util.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Car> raceParticipants = requestCarNames();
        int attemptNumbr = requestAttemptNuber();

        RacingGame racingGame = new RacingGameImpl(raceParticipants, attemptNumbr);
        RaceParticipantsDto raceWinnerDto = startRacing(racingGame);

        printWinner(raceWinnerDto);
    }

    private List<Car> requestCarNames() {
        outputView.requestRacingcarName();
        String carNamesInput = inputView.getInput();
        return InputValidator.racingcars(carNamesInput);
    }

    private int requestAttemptNuber() {
        outputView.requestAttemptNumber();
        String attemptNumberInput = inputView.getInput();
        return InputValidator.attemptNumber(attemptNumberInput);
    }

    private RaceParticipantsDto startRacing(RacingGame racingGame) {
        outputView.startPrintingRoundResult();

        while(racingGame.notFinished()) {
            racingGame.playOneRound();

            RaceParticipantsDto currentResult = racingGame.getRoundResultDto();
            outputView.printRoundResult(currentResult);
        }

        return racingGame.getRoundWinnerResultDto();
    }

    private void printWinner(RaceParticipantsDto raceWinnerDto) {
        outputView.startPrintingFinalWinner();
        outputView.printFinalWinners(raceWinnerDto);
    }
}

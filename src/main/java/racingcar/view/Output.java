package racingcar.view;

import static racingcar.common.message.ViewMessage.EXECUTION_RESULT_MESSAGE;
import static racingcar.common.message.ViewMessage.REQUEST_RACINGCAR_MESSAGE;
import static racingcar.common.message.ViewMessage.REQUEST_ATTEMPT_NUMBER_MESSAGE;
import static racingcar.common.message.ViewMessage.NAME_RESULT_SEPARATOR;
import static racingcar.common.message.ViewMessage.DISTANCE_UNIT;
import static racingcar.common.message.ViewMessage.FINAL_WINNER_MESSAGE;
import static racingcar.common.message.ViewMessage.WINNER_SEPARATOR;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.CarDto;
import racingcar.model.RoundResultDto;

public class Output {

    public void requestRacingcarName() {
        System.out.println(REQUEST_RACINGCAR_MESSAGE.getMessage());
    }

    public void requestAttemptNumber() {
        System.out.println(REQUEST_ATTEMPT_NUMBER_MESSAGE.getMessage());
    }

    public void startPrintingRoundResult() {
        System.out.println(EXECUTION_RESULT_MESSAGE.getMessage());
    }

    public void printRoundResult(RoundResultDto currentResult) {
        List<CarDto> participants = currentResult.participantsDto();

        for(CarDto participant : participants) {
            String racingPositionResult = DISTANCE_UNIT.getMessage().repeat(participant.position());
            System.out.println(participant.carName() + NAME_RESULT_SEPARATOR.getMessage() + racingPositionResult);
        }

        System.out.println();
    }

    public void startPrintingFinalWinner() {
        System.out.print(FINAL_WINNER_MESSAGE.getMessage());
    }

    public void printFinalWinners(RoundResultDto finalWinnersResultDto) {
        System.out.println(finalWinnersResultDto.participantsDto()
                .stream()
                .map(CarDto::carName)
                .collect(Collectors.joining(WINNER_SEPARATOR.getMessage())));
    }
}

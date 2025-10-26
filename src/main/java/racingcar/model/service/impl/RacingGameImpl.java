package racingcar.model.service.impl;

import java.util.List;
import static racingcar.common.constant.RacingGameStrategy.moveStrategy;
import racingcar.model.Car;
import racingcar.model.RaceParticipantsDto;
import racingcar.model.firstclasscollection.RaceParticipants;
import racingcar.model.service.RacingGame;

public class RacingGameImpl implements RacingGame {

    private final RaceParticipants raceParticipants;
    private int remainingAttempt;

    public RacingGameImpl(List<Car> racingcars, int remainingAttempt) {
        this.raceParticipants = new RaceParticipants(racingcars);
        this.remainingAttempt = remainingAttempt;
    }

    @Override
    public Boolean notFinished() {
        if (remainingAttempt <= 0 || raceParticipants.crossFinishline()) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    public void playOneRound() {
        this.remainingAttempt--;
        raceParticipants.tryMove(moveStrategy);
    };

    @Override
    public RaceParticipantsDto getRoundResultDto() {
        return RaceParticipantsDto.from(raceParticipants);
    }

    @Override
    public RaceParticipantsDto getRoundWinnerResultDto() {
       return new RaceParticipantsDto(raceParticipants.getRoundWinnersDto());
    }
}

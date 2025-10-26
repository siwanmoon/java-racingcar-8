package racingcar.model.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.function.Supplier;
import static racingcar.common.constant.RacingGameStrategy.RANDOM_NUMBER_MAX;
import static racingcar.common.constant.RacingGameStrategy.RANDOM_NUMBER_MIN;
import racingcar.model.Car;
import racingcar.model.RoundResultDto;
import racingcar.model.firstclasscollection.RaceParticipants;
import racingcar.model.service.RacingGame;

public class RacingGameImpl implements RacingGame {

    private final RaceParticipants raceParticipants;
    private int remainingAttempt;
    private final Supplier<Integer> moveStrategy =
            () -> Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);

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
    public RoundResultDto getRoundResultDto() {
        return RoundResultDto.from(raceParticipants);
    }

    @Override
    public RoundResultDto getRoundWinnerResultDto() {
       return new RoundResultDto(raceParticipants.getRoundWinnersDto());
    }
}

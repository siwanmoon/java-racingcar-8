package racingcar.model.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.function.Supplier;
import static racingcar.common.constant.RacingGameService.RANDOM_NUMBER_MAX;
import static racingcar.common.constant.RacingGameService.RANDOM_NUMBER_MIN;
import racingcar.model.Car;
import racingcar.model.firstclasscollection.RaceParticipants;
import racingcar.model.service.RacingGame;

public class RacingGameImpl implements RacingGame {

    private final RaceParticipants raceParticipants;
    private final int attemptNumber;
    private final Supplier<Integer> moveStrategy =
            () -> Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);

    public RacingGameImpl(List<Car> racingcars, int attemptNumber) {
        this.raceParticipants = new RaceParticipants(racingcars);
        this.attemptNumber = attemptNumber;
    }

    @Override
    public Boolean notFinished() {
        if (attemptNumber <= 0 || raceParticipants.crossFinishline()) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    public void playOneRound() {
        raceParticipants.tryMove(moveStrategy);
    };
}

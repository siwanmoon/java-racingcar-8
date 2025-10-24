package racingcar.model.firstclasscollection;

import java.util.List;
import static racingcar.common.constant.RacingGameService.FINISHLINE_POSITION;
import java.util.function.Supplier;
import racingcar.model.Car;

public class RaceParticipants {

    private final List<Car> raceParticipants;

    public RaceParticipants(List<Car> raceParticipants) {
        this.raceParticipants = raceParticipants;
    }

    public boolean crossFinishline() {
        return raceParticipants.stream()
                .anyMatch(car -> car.isPositionGreaterOrEqualThan(FINISHLINE_POSITION));
    }

    public void tryMove(Supplier<Integer> moveStrategy) {
        for (Car participants : raceParticipants) {
            participants.tryMoveForward(moveStrategy.get());
        }
    }
}

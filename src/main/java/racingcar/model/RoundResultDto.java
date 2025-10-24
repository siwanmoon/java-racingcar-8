package racingcar.model;

import java.util.List;
import racingcar.model.firstclasscollection.RaceParticipants;

public record RoundResultDto(List<CarDto> participantsDto) {

    public static RoundResultDto from(RaceParticipants raceParticipants) {
        return new RoundResultDto(raceParticipants.getRoundResult());
    }
}

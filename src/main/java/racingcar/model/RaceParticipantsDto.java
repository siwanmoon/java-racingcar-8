package racingcar.model;

import java.util.List;
import racingcar.model.firstclasscollection.RaceParticipants;

public record RaceParticipantsDto(List<CarDto> participantsDto) {

    public static RaceParticipantsDto from(RaceParticipants raceParticipants) {
        return new RaceParticipantsDto(raceParticipants.getParticipantsDto());
    }
}

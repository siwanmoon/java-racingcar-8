package racingcar.model.service;

import racingcar.model.RaceParticipantsDto;

public interface RacingGame {

    Boolean notFinished();
    void playOneRound();
    RaceParticipantsDto getRoundResultDto();
    RaceParticipantsDto getRoundWinnerResultDto();
}

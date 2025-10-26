package racingcar.model.service;

import racingcar.model.RoundResultDto;

public interface RacingGame {

    Boolean notFinished();
    void playOneRound();
    RoundResultDto getRoundResultDto();
    RoundResultDto getRoundWinnerResultDto();
}

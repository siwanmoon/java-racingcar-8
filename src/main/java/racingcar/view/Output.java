package racingcar.view;

import static racingcar.common.message.ViewMessage.REQUEST_RACINGCAR_MESSAGE;
import static racingcar.common.message.ViewMessage.REQUEST_ATTEMPT_NUMBER_MESSAGE;

public class Output {

    public void requestRacingcarName() {
        System.out.println(REQUEST_RACINGCAR_MESSAGE.getMessage());
    }

    public void requestAttemptNumber() {
        System.out.println(REQUEST_ATTEMPT_NUMBER_MESSAGE.getMessage());
    }
}

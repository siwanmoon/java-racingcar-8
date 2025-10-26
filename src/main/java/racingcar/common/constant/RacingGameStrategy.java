package racingcar.common.constant;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.Supplier;

public final class RacingGameStrategy {

    public static final int STARTLINE_POSITION = 0;
    public static final int FINISHLINE_POSITION = 100;
    public static final int RANDOM_NUMBER_MIN = 0;
    public static final int RANDOM_NUMBER_MAX = 9;
    public static final int MINIMUM_MOVE_VALUE = 4;
    public static final Supplier<Integer> moveStrategy =
            () -> Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);

    private RacingGameStrategy() {

    }
}

package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static racingcar.common.constant.Validator.RACINGCARNAME_REGEX;
import static racingcar.common.message.ErrorMessage.RACINGCAR_ATTEMPT_BLANK;
import static racingcar.common.message.ErrorMessage.RACINGCAR_NAME_BLANCK;
import static racingcar.common.message.ErrorMessage.RACINGCAR_NAME_NOT_ENGLISH;
import static racingcar.common.message.ErrorMessage.RACINGCAR_NAME_NOT_UNIQUE;
import static racingcar.common.message.ErrorMessage.RACINGCAR_ATTEMPT_NOT_NUBER;
import racingcar.model.Car;

public class InputValidator {

    public List<Car> racingcars (String input) {
        List<String> racingcarNames = Arrays.stream(input.split(",")).map(String::trim).toList();
        List<Car> racingcars = new ArrayList<>();

        Set<String> uniqueRacingcarNames = new HashSet<>(racingcarNames);

        if (racingcarNames.size() != uniqueRacingcarNames.size()) {
            throw new IllegalArgumentException(RACINGCAR_NAME_NOT_UNIQUE.getMessage());
        }

        for (String racingcarName : racingcarNames) {
            if (racingcarName.isBlank()) {
                throw new IllegalArgumentException(RACINGCAR_NAME_BLANCK.getMessage());
            }

            if (!racingcarName.matches(RACINGCARNAME_REGEX.getConstant())) {
                throw new IllegalArgumentException(RACINGCAR_NAME_NOT_ENGLISH.getMessage());
            }

            racingcars.add(new Car(racingcarName, 0));
        }

        return racingcars;
    }

    public int attemptNumber (String input) {

        int inputInteger;

        if (input.isBlank()) {
            throw new IllegalArgumentException(RACINGCAR_ATTEMPT_BLANK.getMessage());
        }

        try {
            inputInteger = Integer.parseInt(input.trim());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(RACINGCAR_ATTEMPT_NOT_NUBER.getMessage());
        }

        return inputInteger;
    }
}

package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static racingcar.common.constant.Validator.MIN_ATTEMPT_AMOUNT;
import static racingcar.common.constant.Validator.RACINGCAR_NAME_REGEX;
import static racingcar.common.constant.Validator.MIN_RACINGCAR_AMOUNT;
import static racingcar.common.message.ErrorMessage.ATTEMPT_NOT_POSITIVE_NUMBER;
import static racingcar.common.message.ErrorMessage.RACINGCAR_ATTEMPT_BLANK;
import static racingcar.common.message.ErrorMessage.RACINGCAR_NAME_BLANCK;
import static racingcar.common.message.ErrorMessage.RACINGCAR_NAME_NOT_ENGLISH;
import static racingcar.common.message.ErrorMessage.RACINGCAR_NAME_NOT_UNIQUE;
import static racingcar.common.message.ErrorMessage.RACINGCAR_ATTEMPT_NOT_NUBER;
import static racingcar.common.message.ErrorMessage.RACINGCAR_NOT_ENOUGH;

import racingcar.model.Car;

public class InputValidator {

    public static List<Car> racingcars (String input) {
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

            if (!racingcarName.matches(RACINGCAR_NAME_REGEX)) {
                throw new IllegalArgumentException(RACINGCAR_NAME_NOT_ENGLISH.getMessage());
            }

            racingcars.add(new Car(racingcarName, 0));
        }

        if (racingcars.size() < MIN_RACINGCAR_AMOUNT) {
            throw new IllegalArgumentException(RACINGCAR_NOT_ENOUGH.getMessage());
        }

        return racingcars;
    }

    public static int attemptNumber (String input) {
        int inputInteger;

        if (input.isBlank()) {
            throw new IllegalArgumentException(RACINGCAR_ATTEMPT_BLANK.getMessage());
        }

        try {
            inputInteger = Integer.parseInt(input.trim());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(RACINGCAR_ATTEMPT_NOT_NUBER.getMessage());
        }

        if (inputInteger < MIN_ATTEMPT_AMOUNT) {
            throw new IllegalArgumentException(ATTEMPT_NOT_POSITIVE_NUMBER.getMessage());
        }

        return inputInteger;
    }
}

package racingcar.common.message;

public enum ErrorMessage {

    RACINGCAR_NAME_BLANCK("자동차의 이름이 입력되지 않았습니다"),
    RACINGCAR_NAME_NOT_ENGLISH("자동차의 이름으로 영문자만 사용 가능합니다"),
    RACINGCAR_NAME_NOT_UNIQUE("자동차의 이름이 중복으로 입력되었습니다"),
    RACINGCAR_ATTEMPT_BLANK("시행횟수가 입력되지 않았습니다"),
    RACINGCAR_ATTEMPT_NOT_NUBER("횟수는 숫자로 입력되어야합니다"),
    RACINGCAR_NAME_LENGTH_OVERFLOW("자동차의 이름은 5자 이하로 입력되어야 합니다"),
    RACINGCAR_NOT_ENOUGH("경주할 자동차가 더 많아야 합니다"),
    ATTEMPT_NOT_POSITIVE_NUMBER("시도할 횟수는 양수여야 합니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

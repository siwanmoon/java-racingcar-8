package racingcar.common.constant;

public enum Validator {

    RACINGCARNAME_REGEX("^[a-zA-Z]+$");

    private final String constant;

    Validator(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}

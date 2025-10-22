package racingcar.common.message;

public enum ViewMessage {

    REQUEST_RACINGCAR_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_ATTEMPT_NUMBER_MESSAGE("시도할 횟수는 몇 회인가요?"),
    EXECUTION_RESULT_MESSAGE("실행 결과"),
    FINAL_WINNER_MESSAGE("최종 우승자 : ");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

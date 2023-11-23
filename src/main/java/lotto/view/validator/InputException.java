package lotto.view.validator;

public enum InputException {
    BLANK("공백 입력은 안됩니다."),
    EXCEED_INPUT_LENGTH("로또 구입 금액 입력은 9자를 초과할 수 없습니다."),
    NOT_NUMERIC("숫자가 아닌 입력이 존재합니다."),
    INVALID_WINNING_NUMBER_FORM("콤마는 입력 처음과 끝에 존재해선 안됩니다.");

    private String PREFIX = "[ERROR] ";
    private final String message;

    InputException(String message) {
        this.message = message;
    }

    public void make() {
        throw new IllegalArgumentException(PREFIX + message);
    }

    public String getMessage() {
        return PREFIX + message;
    }
}

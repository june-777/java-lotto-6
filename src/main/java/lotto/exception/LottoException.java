package lotto.exception;

public enum LottoException {
    LOTTO_NUMBER_OUT_OF_RANGE("로또 숫자는 1 ~ 45 범위여야 합니다."),
    LOTTO_DUPLICATE("로또는 중복되지 않는 숫자로 이루어져야 합니다."),
    LOTTO_OUT_OF_SIZE("로또는 6개의 숫자로 이루어져야 합니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복이여선 안됩니다.");

    private String PREFIX = "[ERROR] ";
    private final String message;

    LottoException(String message) {
        this.message = message;
    }

    public void make() {
        throw new IllegalArgumentException(PREFIX + message);
    }

    public String getMessage() {
        return PREFIX + message;
    }
}

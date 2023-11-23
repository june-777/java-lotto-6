package lotto.exception;

public enum PurchaseAmountException {

    NOT_ENOUGH_AMOUNT("최소 구입 금액은 1,000원 입니다."),
    INVALID_UNIT("구입 금액은 1,000원 단위여야 합니다.");

    private String PREFIX = "[ERROR] ";
    private final String message;

    PurchaseAmountException(String message) {
        this.message = message;
    }

    public void make() {
        throw new IllegalArgumentException(PREFIX + message);
    }

    public String getMessage() {
        return PREFIX + message;
    }
}

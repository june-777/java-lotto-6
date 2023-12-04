package lotto.domain;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateRange(amount);
        validateUnit(amount);
    }

    private void validateRange(int amount) {
        if (amount < 1000 || amount > 100000) {
            throw new IllegalArgumentException("구입 금액의 범위가 잘못 되었습니다.");
        }
    }

    private void validateUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}

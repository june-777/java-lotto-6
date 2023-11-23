package lotto.domain;

import lotto.exception.PurchaseAmountException;

public class PurchaseAmount {
    private static final int UNIT = 1000;
    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateMin(amount);
        validateUnit(amount);
    }

    private void validateMin(int amount) {
        if (amount < UNIT) {
            PurchaseAmountException.NOT_ENOUGH_AMOUNT.make();
        }
    }

    private void validateUnit(int amount) {
        if (amount % UNIT != 0) {
            PurchaseAmountException.INVALID_UNIT.make();
        }
    }

    public int calculatePurchaseCount() {
        return amount / UNIT;
    }
}

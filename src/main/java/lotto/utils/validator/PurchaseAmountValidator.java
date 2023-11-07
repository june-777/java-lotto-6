package lotto.utils.validator;

import lotto.utils.message.PurchaseAmountExceptionMessage;

public class PurchaseAmountValidator {

    private static final long LOTTO_COUNTS_MAX_LIMIT = 100_000L;
    private static final long LOTTO_PRICE_UNIT = 1000L;

    public static void validate(String input) {
        validateBlank(input);
        validateMaxLength(input);
        validateNumeric(input);
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(PurchaseAmountExceptionMessage.BLANK.getError());
        }
    }

    private static void validateMaxLength(String input) {
        if (input == null || input.length() > String.valueOf(LOTTO_COUNTS_MAX_LIMIT * LOTTO_PRICE_UNIT).length()) {
            throw new IllegalArgumentException(PurchaseAmountExceptionMessage.EXCEED_LENGTH.getError());
        }
    }

    private static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PurchaseAmountExceptionMessage.NOT_NUMERIC.getError(), e);
        }
    }
}

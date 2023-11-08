package lotto.view.validator;

import lotto.utils.message.PurchaseAmountExceptionMessage;

public class PurchaseAmountInputValidator {
    private static final int MAX_LENGTH = 9;

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
        if (input == null || input.length() > MAX_LENGTH) {
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

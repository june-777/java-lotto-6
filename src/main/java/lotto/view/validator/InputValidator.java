package lotto.view.validator;

public class InputValidator {

    private static final int PURCHASE_AMOUNT_LENGTH = 9;

    public static void validatePurchaseAmount(String purchaseAmount) {
        validateBlank(purchaseAmount);
        validateMaxLength(purchaseAmount);
        validateNumeric(purchaseAmount);
    }

    private static void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            InputException.BLANK.make();
        }
    }

    private static void validateMaxLength(String target) {
        if (target.length() > PURCHASE_AMOUNT_LENGTH) {
            InputException.EXCEED_PURCHASE_AMOUNT_LENGTH.make();
        }
    }

    private static void validateNumeric(String target) {
        if (!isNumeric(target)) {
            InputException.NOT_NUMERIC.make();
        }
    }

    private static boolean isNumeric(String target) {
        try {
            Integer.parseInt(target);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

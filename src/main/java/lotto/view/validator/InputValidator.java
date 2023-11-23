package lotto.view.validator;

import java.util.Arrays;

public class InputValidator {

    private static final int PURCHASE_AMOUNT_LENGTH = 9;
    private static final int WINNING_NUMBERS_LENGTH = 17;
    private static final int BONUS_NUMBER_LENGTH = 2;
    private static final char SEPERATOR = ',';

    public static void validatePurchaseAmount(String purchaseAmount) {
        validateBlank(purchaseAmount);
        validateMaxLength(purchaseAmount, PURCHASE_AMOUNT_LENGTH);
        validateNumeric(purchaseAmount);
    }

    public static void validateWinningNumbers(String winningNumbers) {
        validateBlank(winningNumbers);
        validateMaxLength(winningNumbers, WINNING_NUMBERS_LENGTH);
        validateWinningNumbersInputForm(winningNumbers);
        validateAllNumeric(winningNumbers);
    }

    public static void validateBonusNumber(String bonusNumber) {
        validateBlank(bonusNumber);
        validateMaxLength(bonusNumber, BONUS_NUMBER_LENGTH);
        validateNumeric(bonusNumber);
    }

    private static void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            InputException.BLANK.make();
        }
    }

    private static void validateMaxLength(String target, int limitLength) {
        if (target.length() > limitLength) {
            InputException.EXCEED_INPUT_LENGTH.make();
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

    private static void validateWinningNumbersInputForm(String target) {
        if (isFirstCharacterIsSeperator(target) || isLastCharacterIsSeperator(target)) {
            InputException.INVALID_WINNING_NUMBER_FORM.make();
        }
    }

    private static boolean isFirstCharacterIsSeperator(String target) {
        return target.charAt(0) == SEPERATOR;
    }

    private static boolean isLastCharacterIsSeperator(String target) {
        return target.charAt(target.length() - 1) == SEPERATOR;
    }

    private static void validateAllNumeric(String target) {
        boolean notNumericExist = Arrays.stream(target.split(","))
                .anyMatch(InputValidator::isNumeric);

        if (notNumericExist) {
            InputException.NOT_NUMERIC.make();
        }
    }
}

package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.view.reader.Reader;
import lotto.view.validator.InputValidator;

public class InputView {

    public final Reader reader;

    public InputView(Reader reader) {
        this.reader = reader;
    }

    public int readPurchaseAmount() {
        System.out.println(Message.PURCHASE_AMOUNT.message);
        String purchaseAmountInput = reader.readLine();
        InputValidator.validatePurchaseAmount(purchaseAmountInput);
        return Integer.parseInt(purchaseAmountInput);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println();
        System.out.println(Message.WINNING_NUMBERS.message);
        String winningNumberInput = reader.readLine();
        InputValidator.validateWinningNumbers(winningNumberInput);
        return mapFrom(winningNumberInput);
    }

    private List<Integer> mapFrom(String winningNumberInput) {
        return Arrays.stream(winningNumberInput.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public int readBonusNumber() {
        System.out.println();
        System.out.println(Message.BONUS_NUMBER.message);
        String bonusNumberInput = reader.readLine();
        InputValidator.validateBonusNumber(bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }

    private enum Message {
        PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
        WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}

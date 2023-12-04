package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public int readPurchaseAmount() {
        System.out.println(Message.PURCHASE_AMOUNT.message);
        String purchaseAmountInput = Console.readLine();
        validateBlank(purchaseAmountInput);

        return Integer.parseInt(purchaseAmountInput);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println();
        System.out.println(Message.WINNING_NUMBER.message);
        String winningNumberInput = Console.readLine();
        validateBlank(winningNumberInput);

        return Arrays.stream((winningNumberInput.split(",")))
                .map(Integer::parseInt)
                .toList();
    }

    public int readBonusNumber() {
        System.out.println();
        System.out.println(Message.BONUS_NUMBER.message);
        String bonusNumberInput = Console.readLine();

        return Integer.parseInt(bonusNumberInput);
    }

    private void validateBlank(String target) {
        if (target == null || target.isBlank()) {
            throw new IllegalArgumentException("공백 입력은 안됩니다.");
        }
    }

    private enum Message {
        PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
        WINNING_NUMBER("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}

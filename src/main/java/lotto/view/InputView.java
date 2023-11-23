package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.view.reader.Reader;

public class InputView {

    public final Reader reader;

    public InputView(Reader reader) {
        this.reader = reader;
    }

    public int readPurchaseAmount() {
        String purchaseAmountInput = reader.readLine();
        // TODO: input validate
        return Integer.parseInt(purchaseAmountInput);
    }

    public List<Integer> readWinningNumbers() {
        String winningNumberInput = reader.readLine();
        // TODO: input validate
        return mapFrom(winningNumberInput);
    }

    private List<Integer> mapFrom(String winningNumberInput) {
        return Arrays.stream(winningNumberInput.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}

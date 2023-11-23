package lotto.view;

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
}

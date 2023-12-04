package lotto.controller;

import lotto.configuration.ExceptionHandler;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

public class FrontController {
    private final Controller controller;

    public FrontController(Controller controller) {
        this.controller = controller;
    }

    public void process() {
        PurchaseAmount purchaseAmount = ExceptionHandler.retryOrGet(controller::initPurchaseAmount);
        WinningLotto winningLotto = ExceptionHandler.retryOrGet(controller::initWinningLotto);

        controller.process(purchaseAmount, winningLotto);
    }
}

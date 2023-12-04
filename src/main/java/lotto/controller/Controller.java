package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class Controller {

    private final InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public PurchaseAmount initPurchaseAmount() {
        int purchaseAmountInput = inputView.readPurchaseAmount();
        return new PurchaseAmount(purchaseAmountInput);
    }

    public WinningLotto initWinningLotto() {
        List<Integer> winningNumbersInput = inputView.readWinningNumbers();
        Lotto winningNumbers = new Lotto(winningNumbersInput);

        int bonusNumberInput = inputView.readBonusNumber();
        LottoNumber bonus = new LottoNumber(bonusNumberInput);
        return new WinningLotto(winningNumbers, bonus);
    }

    public void process(final PurchaseAmount purchaseAmount, final WinningLotto winningLotto) {
        System.out.println("당첨 통계 서비스 시작");
    }
}

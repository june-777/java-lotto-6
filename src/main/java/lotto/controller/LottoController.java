package lotto.controller;

import java.util.List;
import lotto.domain.PurchaseAmount;
import lotto.domain.lotto.Lotto;
import lotto.service.LottoOffice;
import lotto.view.InputView;
import lotto.view.PurchaseLottoView;

public class LottoController {

    private final InputView inputView;
    private final LottoOffice lottoOffice;

    public LottoController(InputView inputView, LottoOffice lottoOffice) {
        this.inputView = inputView;
        this.lottoOffice = lottoOffice;
    }

    public void process() {
        PurchaseAmount purchaseAmount = setPurchaseAmount();
        List<Lotto> lottos = lottoOffice.issueLottos(purchaseAmount);
        PurchaseLottoView.print(mapFrom(lottos));
    }

    private PurchaseAmount setPurchaseAmount() {
        return ExceptionHandler.handle(() -> {
            int purchaseAmount = inputView.readPurchaseAmount();
            return new PurchaseAmount(purchaseAmount);
        });
    }

    private List<List<Integer>> mapFrom(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::calculateNumbers)
                .toList();
    }
}

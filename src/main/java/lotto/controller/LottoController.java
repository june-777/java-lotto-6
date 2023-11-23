package lotto.controller;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.PlayerResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.PlayerLotto;
import lotto.domain.lotto.WinningInformation;
import lotto.dto.mapper.PurchaseLottoViewMapper;
import lotto.service.LottoOffice;
import lotto.service.YieldCalculator;
import lotto.view.InputView;
import lotto.view.PurchaseLottoView;
import lotto.view.StatisticsView;

public class LottoController {

    private final InputView inputView;
    private final LottoOffice lottoOffice;
    private final YieldCalculator yieldCalculator;

    public LottoController(InputView inputView, LottoOffice lottoOffice, YieldCalculator yieldCalculator) {
        this.inputView = inputView;
        this.lottoOffice = lottoOffice;
        this.yieldCalculator = yieldCalculator;
    }

    public void process() {
        final PurchaseAmount purchaseAmount = setPurchaseAmount();
        final List<Lotto> lottos = lottoOffice.issueLottos(purchaseAmount);
        final PlayerLotto playerLotto = new PlayerLotto(lottos);

        renderingPurchaseLotto(lottos);

        final WinningInformation winningInformation = publishWinningInformation();
        final PlayerResult playerResult = playerLotto.calculateWinningResult(winningInformation);
        final BigDecimal yield = yieldCalculator.calculate(playerResult, purchaseAmount);
        renderingStatistics(playerResult, yield);
    }

    private WinningInformation publishWinningInformation() {
        Lotto lotto = setWinningNumber();
        return setWinningInformation(lotto);
    }

    private void renderingPurchaseLotto(List<Lotto> lottos) {
        PurchaseLottoView.print(PurchaseLottoViewMapper.mapFrom(lottos));
    }

    private PurchaseAmount setPurchaseAmount() {
        return ExceptionHandler.handle(() -> {
            int purchaseAmount = inputView.readPurchaseAmount();
            return new PurchaseAmount(purchaseAmount);
        });
    }

    private Lotto setWinningNumber() {
        return ExceptionHandler.handle(() -> {
            List<Integer> winningNumbersInput = inputView.readWinningNumbers();
            return new Lotto(winningNumbersInput);
        });
    }

    private WinningInformation setWinningInformation(Lotto winningNumbers) {
        return ExceptionHandler.handle(() -> {
            int bonusNumberInput = inputView.readBonusNumber();
            LottoNumber bonusNumber = new LottoNumber(bonusNumberInput);
            return new WinningInformation(winningNumbers, bonusNumber);
        });
    }

    private static void renderingStatistics(PlayerResult playerResult, BigDecimal yield) {
        StatisticsView.print(playerResult.getRankMatchCounts(), yield);
    }
}

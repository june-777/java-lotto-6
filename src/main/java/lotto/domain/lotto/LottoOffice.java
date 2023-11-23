package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.PurchaseAmount;
import lotto.domain.lotto.generator.NumbersGenerator;

public class LottoOffice {
    private final NumbersGenerator lottoNumbersGenerator;

    public LottoOffice(NumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public List<Lotto> issueLottos(PurchaseAmount purchaseAmount) {
        int purchaseCount = purchaseAmount.calculatePurchaseCount();
        return toLottos(purchaseCount);
    }

    private List<Lotto> toLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < purchaseCount; count++) {
            lottos.add(new Lotto(lottoNumbersGenerator.generate()));
        }
        return lottos;
    }

    public WinningInformation publishWinningInformation(Lotto winningNumber, int bonus) {
        LottoNumber bonusNumber = new LottoNumber(bonus);
        return new WinningInformation(winningNumber, bonusNumber);
    }
}

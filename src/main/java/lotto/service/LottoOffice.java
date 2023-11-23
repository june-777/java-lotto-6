package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.PurchaseAmount;
import lotto.domain.lotto.Lotto;

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
}

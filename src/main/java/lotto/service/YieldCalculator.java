package lotto.service;

import java.math.BigDecimal;
import lotto.domain.PlayerResult;
import lotto.domain.PurchaseAmount;

public class YieldCalculator {
    public BigDecimal calculate(PlayerResult playerResult, PurchaseAmount purchaseAmount) {
        long totalPrize = playerResult.calculateTotalPrize();
        return purchaseAmount.calculateYield(totalPrize);
    }
}

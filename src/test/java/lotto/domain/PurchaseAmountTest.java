package lotto.domain;

import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @Test
    void yieldTest() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(7000);
        long totalPrize = 4000;
        BigDecimal expected = new BigDecimal("57.1");
        // when
        BigDecimal result = purchaseAmount.calculateYield(totalPrize);
        // then
        Assertions.assertThat(expected).isEqualTo(result);
    }
}
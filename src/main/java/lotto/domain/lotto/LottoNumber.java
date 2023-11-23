package lotto.domain.lotto;

import lotto.exception.LottoException;

public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;

    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN || number > MAX) {
            LottoException.LOTTO_NUMBER_OUT_OF_RANGE.make();
        }
    }
}

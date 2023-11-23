package lotto.domain.lotto;

import lotto.domain.exception.LottoException;

public class WinningInformation {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningInformation(Lotto winningNumbers, LottoNumber bonusNumber) {
        validateDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.isContains(bonusNumber)) {
            LottoException.BONUS_NUMBER_DUPLICATE.make();
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}

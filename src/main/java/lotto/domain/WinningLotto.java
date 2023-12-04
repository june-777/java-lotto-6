package lotto.domain;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final LottoNumber bonus;

    public WinningLotto(Lotto winningNumbers, LottoNumber bonus) {
        validate(winningNumbers, bonus);
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    private void validate(Lotto winningNumbers, LottoNumber bonus) {
        if (winningNumbers.isContains(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복일 수 없습니다.");
        }
    }
}

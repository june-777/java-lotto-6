package lotto.domain;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 수여야 합니다.");
        }
    }
}

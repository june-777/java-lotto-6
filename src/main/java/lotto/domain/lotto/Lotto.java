package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private static final int REQUIRED_SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = toLottoNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateDuplicate(numbers);
        validateSize(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            LottoException.LOTTO_DUPLICATE.make();
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != REQUIRED_SIZE) {
            LottoException.LOTTO_OUT_OF_SIZE.make();
        }
    }

    private List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .toList();
    }

    public List<Integer> calculateNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
    }

    public boolean isContains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int calculateMatchCounts(Lotto other) {
        int matchCounts = 0;
        for (LottoNumber number : other.numbers) {
            if (isContains(number)) {
                matchCounts++;
            }
        }
        return matchCounts;
    }

    @Override
    public String toString() {
        return "Lotto{" + numbers + '}';
    }
}

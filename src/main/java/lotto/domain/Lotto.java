package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = mapFrom(numbers);
    }

    private List<LottoNumber> mapFrom(List<Integer> numbers) {
        System.out.println("시작");
        List<LottoNumber> list = numbers.stream()
                .map(LottoNumber::new)
                .toList();
        System.out.println("map From 종료");
        return list;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개이어야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복일 수 없습니다.");
        }
    }

    public boolean isContains(LottoNumber number) {
        return numbers.contains(number);
    }
}

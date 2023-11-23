package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("서로 다른 로또가 주어졌을 때")
    @Nested
    class MatchCountTest {

        @DisplayName("로또 번호의 일치 개수를 확인한다.")
        @ParameterizedTest
        @CsvSource(value = {"1,2,3,4,5,6:1,2,3,4,5,6:6",
                "1,2,3,4,5,6:1,2,3,4,5,7:5",
                "1,2,3,4,5,6:1,2,3,4,7,8:4",
                "1,2,3,4,5,6:1,2,3,7,8,9:3",
                "1,2,3,4,5,6:1,2,7,8,9,10:2",
                "1,2,3,4,5,6:1,7,8,9,10,11:1",
                "1,2,3,4,5,6:7,8,9,10,11,12:0"}, delimiter = ':')
        void matchCount(String lottoInputOne, String lottoInputTwo, int matchCount) {
            Lotto lotto1 = new Lotto(mapFrom(lottoInputOne));
            Lotto lotto2 = new Lotto(mapFrom(lottoInputTwo));

            int result = lotto1.calculateMatchCounts(lotto2);
            Assertions.assertThat(result).isEqualTo(matchCount);
        }

        private List<Integer> mapFrom(String winningNumberInput) {
            return Arrays.stream(winningNumberInput.split(","))
                    .map(Integer::parseInt)
                    .toList();
        }
    }
}
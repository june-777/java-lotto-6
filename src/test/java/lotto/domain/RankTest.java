package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @DisplayName("당첨 번호 개수와 보너스 매칭 여부가 주어졌을 때")
    @Nested
    class CalculateRank {
        @DisplayName("당첨번호 6개, 보너스 매칭 true/false 은 1등이다.")
        @ParameterizedTest
        @CsvSource(value = {"6,false", "6,true"})
        void first(int matchCount, boolean bonusMatch) {
            Optional<Rank> rank = Rank.calculateRank(matchCount, bonusMatch);
            assertThat(rank.isPresent()).isTrue();
            assertThat(rank.get()).isEqualTo(Rank.FIRST);
        }

        @DisplayName("당첨번호 5개, 보너스 매칭 true는 2등이다.")
        @ParameterizedTest
        @CsvSource(value = {"5,true"})
        void second(int matchCount, boolean bonusMatch) {
            Optional<Rank> rank = Rank.calculateRank(matchCount, bonusMatch);
            assertThat(rank.isPresent()).isTrue();
            assertThat(rank.get()).isEqualTo(Rank.SECOND);
        }

        @DisplayName("당첨번호 5개, 보너스 매칭 false는 3등이다.")
        @ParameterizedTest
        @CsvSource(value = {"5,false"})
        void third(int matchCount, boolean bonusMatch) {
            Optional<Rank> rank = Rank.calculateRank(matchCount, bonusMatch);
            assertThat(rank.isPresent()).isTrue();
            assertThat(rank.get()).isEqualTo(Rank.THIRD);
        }

        @DisplayName("당첨번호 4개, 보너스 매칭 true/false는 4등이다.")
        @ParameterizedTest
        @CsvSource(value = {"4,false", "4,true"})
        void fourth(int matchCount, boolean bonusMatch) {
            Optional<Rank> rank = Rank.calculateRank(matchCount, bonusMatch);
            assertThat(rank.isPresent()).isTrue();
            assertThat(rank.get()).isEqualTo(Rank.FOURTH);
        }

        @DisplayName("당첨번호 3개, 보너스 매칭 true/false는 5등이다.")
        @ParameterizedTest
        @CsvSource(value = {"3,false", "3,true"})
        void fifth(int matchCount, boolean bonusMatch) {
            Optional<Rank> rank = Rank.calculateRank(matchCount, bonusMatch);
            assertThat(rank.isPresent()).isTrue();
            assertThat(rank.get()).isEqualTo(Rank.FIFTH);
        }

        @DisplayName("그 외의 경우는 순위가 없다.")
        @ParameterizedTest
        @CsvSource(value = {"2,false", "2,true", "1,false", "1,true", "0,true", "0,false"})
        void none(int matchCount, boolean bonusMatch) {
            Optional<Rank> rank = Rank.calculateRank(matchCount, bonusMatch);
            assertThat(rank.isPresent()).isFalse();
        }
    }
}
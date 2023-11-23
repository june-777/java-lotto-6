package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Rank {

    FIRST(6, Arrays.asList(true, false), 2_000_000_000L),
    SECOND(5, Arrays.asList(true), 30_000_000L),
    THIRD(5, Arrays.asList(false), 1_500_000L),
    FOURTH(4, Arrays.asList(true, false), 50_000L),
    FIFTH(3, Arrays.asList(true, false), 5_000L);

    private final int matchCount;
    private final List<Boolean> bonusMatch;
    private final long price;

    Rank(int matchCount, List<Boolean> bonusMatch, long price) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.price = price;
    }

    public static Optional<Rank> calculateRank(int targetMatchCount, boolean targetBonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatched(targetMatchCount, targetBonusMatch))
                .findFirst();
    }

    private boolean isMatched(int matchCount, boolean bonusMatch) {
        return this.matchCount == matchCount && this.bonusMatch.contains(bonusMatch);
    }
}

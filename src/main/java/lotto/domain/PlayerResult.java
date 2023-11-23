package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.rank.Rank;

public class PlayerResult {

    private final Map<Rank, Integer> rankMatchCounts;

    public PlayerResult(Map<Rank, Integer> rankMatchCounts) {
        this.rankMatchCounts = rankMatchCounts;
    }

    public long calculateTotalPrize() {
        long totalPrize = 0;
        for (Rank rank : rankMatchCounts.keySet()) {
            int count = rankMatchCounts.get(rank);
            totalPrize += rank.getPrice() * count;
        }
        return totalPrize;
    }

    public Map<Integer, Integer> getRankMatchCounts() {
        Map<Integer, Integer> result = new HashMap<>();
        for (Rank rank : rankMatchCounts.keySet()) {
            result.put(rank.getRankNumber(), rankMatchCounts.get(rank));
        }
        return result;
    }
}

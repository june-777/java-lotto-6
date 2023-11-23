package lotto.domain.lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.domain.PlayerResult;
import lotto.domain.rank.Rank;

public class PlayerLotto {
    private final List<Lotto> lottos;

    public PlayerLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public PlayerResult calculateWinningResult(WinningInformation winningInformation) {
        Lotto winningNumbers = winningInformation.getWinningNumbers();
        LottoNumber bonusNumber = winningInformation.getBonusNumber();

        Map<Rank, Integer> eachRankCounts = calculateEachRankCounts(winningNumbers, bonusNumber);
        System.out.println(eachRankCounts);
        return new PlayerResult(eachRankCounts);
    }

    private Map<Rank, Integer> calculateEachRankCounts(Lotto winningNumbers, LottoNumber bonusNumber) {
        Map<Rank, Integer> eachRankCounts = initEachRankCounts();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.calculateMatchCounts(winningNumbers);
            boolean bonusContain = lotto.isContains(bonusNumber);
            updateEachRankCounts(matchCount, bonusContain, eachRankCounts);
        }
        return eachRankCounts;
    }

    private Map<Rank, Integer> initEachRankCounts() {
        Map<Rank, Integer> eachRankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            eachRankCounts.put(rank, 0);
        }
        return eachRankCounts;
    }

    private static void updateEachRankCounts(int matchCount, boolean bonusContain,
                                             Map<Rank, Integer> eachRankCounts
    ) {
        Optional<Rank> optionalRank = Rank.calculateRank(matchCount, bonusContain);

        if (optionalRank.isPresent()) {
            Rank rank = optionalRank.get();
            eachRankCounts.put(rank, eachRankCounts.getOrDefault(rank, 0) + 1);
        }
    }
}

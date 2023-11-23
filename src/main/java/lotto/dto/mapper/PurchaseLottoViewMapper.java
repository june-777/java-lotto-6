package lotto.dto.mapper;

import java.util.List;
import lotto.domain.lotto.Lotto;

public class PurchaseLottoViewMapper {
    public static List<List<Integer>> mapFrom(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::calculateNumbers)
                .toList();
    }
}

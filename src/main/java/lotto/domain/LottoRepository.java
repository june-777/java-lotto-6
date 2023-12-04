package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRepository {
    private static final List<Lotto> lottos = new ArrayList<>();
    private static final List<WinningLotto> winningLotto = new ArrayList<>();

    public static List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}

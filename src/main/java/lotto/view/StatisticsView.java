package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;

public class StatisticsView {
    private static final DecimalFormat PRICE_FORMAT = new DecimalFormat("###,##0.0");
    private static final int FIRST = 1;
    private static final int SECOND = 2;
    private static final int THIRD = 3;
    private static final int FOURTH = 4;
    private static final int FIFTH = 5;

    public static void print(Map<Integer, Integer> rankCounts, BigDecimal yield) {
        String result = Message.STATISTIC.getMessage(
                rankCounts.get(FIFTH), rankCounts.get(FOURTH), rankCounts.get(THIRD),
                rankCounts.get(SECOND), rankCounts.get(FIRST), PRICE_FORMAT.format(yield.doubleValue()));
        System.out.println(result);
    }

    private enum Message {
        STATISTIC("""
                당첨 통계
                ---
                3개 일치 (5,000원) - %d개
                4개 일치 (50,000원) - %d개
                5개 일치 (1,500,000원) - %d개
                5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                6개 일치 (2,000,000,000원) - %d개
                총 수익률은 %s%%입니다.
                """);

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage(Object... arguments) {
            return String.format(message, arguments);
        }
    }
}

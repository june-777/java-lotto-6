package lotto.view;

import java.util.List;

public class PurchaseLottoView {

    public static void print(List<List<Integer>> purchaseLottos) {
        printPurchaseLottos(purchaseLottos);
    }

    private static void printPurchaseLottos(List<List<Integer>> purchaseLottos) {
        System.out.println();
        System.out.printf(Message.PURCHASE_COUNT.message, purchaseLottos.size());
        System.out.println();
        for (List<Integer> purchaseLotto : purchaseLottos) {
            // TODO: String.join써서 구매 로또간에 공백\n으로 연결해줘야 함
            System.out.println(purchaseLotto);
        }
    }

    private static void toResultForm(List<List<Integer>> purchaseLottos) {
    }

    private enum Message {
        PURCHASE_COUNT("%d개를 구매했습니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}

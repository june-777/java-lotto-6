package lotto;

import lotto.configuration.ApplicationConfiguration;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();
        LottoController lottoController = applicationConfiguration.lottoController();
        lottoController.process();
    }
}

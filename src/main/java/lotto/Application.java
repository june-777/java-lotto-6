package lotto;

import lotto.configuration.ApplicationConfiguration;
import lotto.controller.FrontController;

public class Application {
    public static void main(String[] args) {
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();
        FrontController controller = applicationConfiguration.frontController();

        controller.process();
    }
}

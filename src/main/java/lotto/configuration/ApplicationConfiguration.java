package lotto.configuration;

import lotto.controller.Controller;
import lotto.controller.FrontController;
import lotto.view.InputView;

public class ApplicationConfiguration {

    public FrontController frontController() {
        return new FrontController(controller());
    }

    private Controller controller() {
        return new Controller(inputView());
    }

    private InputView inputView() {
        return new InputView();
    }
}

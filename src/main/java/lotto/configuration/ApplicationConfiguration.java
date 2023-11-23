package lotto.configuration;

import lotto.controller.LottoController;
import lotto.domain.lotto.LottoOffice;
import lotto.domain.lotto.generator.NumbersGenerator;
import lotto.domain.lotto.generator.RandomNumbersGenerator;
import lotto.service.YieldCalculator;
import lotto.view.InputView;
import lotto.view.reader.ConsoleReader;
import lotto.view.reader.Reader;

public class ApplicationConfiguration {

    public LottoController lottoController() {
        return new LottoController(inputView(), lottoOffice(), yieldCalculator());
    }

    private InputView inputView() {
        return new InputView(consoleReader());
    }

    private Reader consoleReader() {
        return new ConsoleReader();
    }

    private LottoOffice lottoOffice() {
        return new LottoOffice(randomNumbersGenerator());
    }

    private NumbersGenerator randomNumbersGenerator() {
        return new RandomNumbersGenerator();
    }

    private YieldCalculator yieldCalculator() {
        return new YieldCalculator();
    }
}

package lotto.view;

import lotto.view.validator.InputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


/**
 * 여기까지 1시간 17분 소요;;
 */
class InputViewTest {

    static final String EXCEPTION_PREFIX = "[Exception]";

    @DisplayName("로또 구입 금액을 입력 받을 때")
    @Nested
    class InputLottoPurchaseAmount {

        @DisplayName(EXCEPTION_PREFIX + "공백 입력 시 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {
                "", " ", "   ", "    ", "     ",
                "\n", "\t", "\r"})
        void blank(String input) {
            InputView inputView = new InputView(() -> input);
            Assertions.assertThatThrownBy(inputView::readPurchaseAmount)
                    .hasMessage(InputException.BLANK.getMessage());
        }

        @DisplayName(EXCEPTION_PREFIX + "최대 입력 길이를 초과하면 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {"         1", "1234567890"})
        void exceedLength(String input) {
            InputView inputView = new InputView(() -> input);
            Assertions.assertThatThrownBy(inputView::readPurchaseAmount)
                    .hasMessage(InputException.EXCEED_INPUT_LENGTH.getMessage());
        }

        @DisplayName(EXCEPTION_PREFIX + "숫자 아닌 입력 시 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {"!", "sdf", "ㄱㄱㄱ", "df1"})
        void notNumeric(String input) {
            InputView inputView = new InputView(() -> input);
            Assertions.assertThatThrownBy(inputView::readPurchaseAmount)
                    .hasMessage(InputException.NOT_NUMERIC.getMessage());
        }
    }

    @DisplayName("당첨 번호를 입력 받았을 때")
    @Nested
    class InputWinningNumbers {

        @DisplayName(EXCEPTION_PREFIX + "공백 입력 시 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {
                "", " ", "   ", "    ", "     ",
                "\n", "\t", "\r"})
        void blank(String input) {
            InputView inputView = new InputView(() -> input);
            Assertions.assertThatThrownBy(inputView::readWinningNumbers)
                    .hasMessage(InputException.BLANK.getMessage());
        }

        @DisplayName(EXCEPTION_PREFIX + "최대 입력 길이를 초과하면 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {"11,12,13,14,15,16,1", "11,12,13,14,15,16 "})
        void exceedLength(String input) {
            InputView inputView = new InputView(() -> input);
            Assertions.assertThatThrownBy(inputView::readWinningNumbers)
                    .hasMessage(InputException.EXCEED_INPUT_LENGTH.getMessage());
        }

        @DisplayName(EXCEPTION_PREFIX + "양 끝에 쉼표가 존재하면 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {",11,12,13,14,15", "12,13,14,15,16,"})
        void invalidForm(String input) {
            InputView inputView = new InputView(() -> input);
            Assertions.assertThatThrownBy(inputView::readWinningNumbers)
                    .hasMessage(InputException.INVALID_WINNING_NUMBER_FORM.getMessage());
        }

        @DisplayName(EXCEPTION_PREFIX + "쉼표 구분 후 숫자가 아닌 입력시 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {"11,12,,13,14,15", "12,13,14,15,16, ", "12,ㄱㄱ,12", "1, ,23"})
        void notNumeric(String input) {
            InputView inputView = new InputView(() -> input);
            Assertions.assertThatThrownBy(inputView::readWinningNumbers)
                    .hasMessage(InputException.NOT_NUMERIC.getMessage());
        }
    }

    @DisplayName("로또 구입 금액을 입력 받을 때")
    @Nested
    class InputBonusNumber {

        @DisplayName(EXCEPTION_PREFIX + "공백 입력 시 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {
                "", " ", "   ", "    ", "     ",
                "\n", "\t", "\r"})
        void blank(String input) {
            InputView inputView = new InputView(() -> input);
            Assertions.assertThatThrownBy(inputView::readBonusNumber)
                    .hasMessage(InputException.BLANK.getMessage());
        }

        @DisplayName(EXCEPTION_PREFIX + "최대 입력 길이를 초과하면 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {"45 ", "123"})
        void exceedLength(String input) {
            InputView inputView = new InputView(() -> input);
            Assertions.assertThatThrownBy(inputView::readBonusNumber)
                    .hasMessage(InputException.EXCEED_INPUT_LENGTH.getMessage());
        }

        @DisplayName(EXCEPTION_PREFIX + "숫자 아닌 입력 시 예외 발생")
        @ParameterizedTest
        @ValueSource(strings = {"!", "I7", "ㄱㄱ", "1r", " 1", "2 "})
        void notNumeric(String input) {
            InputView inputView = new InputView(() -> input);
            Assertions.assertThatThrownBy(inputView::readBonusNumber)
                    .hasMessage(InputException.NOT_NUMERIC.getMessage());
        }
    }
}
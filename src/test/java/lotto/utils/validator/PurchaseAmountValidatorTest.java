package lotto.utils.validator;

import lotto.utils.message.PurchaseAmountExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "    ", "     ", "      ", "\n", "\r", "\t"})
    @DisplayName("[Exception] 공백만 입력")
    void onlyBlank(String input) {
        Assertions.assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .hasMessage(PurchaseAmountExceptionMessage.BLANK.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000000000", "2147483647"})
    @DisplayName("[Exception] 최대 9자리 초과 입력")
    void exceedLength(String input) {
        Assertions.assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .hasMessage(PurchaseAmountExceptionMessage.EXCEED_LENGTH.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1000", "1000 ", " 1000 ", " 1000   ", "  1000   ", "    1000 "})
    @DisplayName("[Exception] 숫자와 공백 혼합 입력")
    void numericWithBlank(String input) {
        Assertions.assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .hasMessage(PurchaseAmountExceptionMessage.NOT_NUMERIC.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"r1000", "m1000", "zzz", "!_!", "dfdf", "Iooo"})
    @DisplayName("[Exception] 문자 입력")
    void notNumeric(String input) {
        Assertions.assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .hasMessage(PurchaseAmountExceptionMessage.NOT_NUMERIC.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "999", "100000001", "-1", "-999"})
    @DisplayName("[Exception] 유효하지 않은 구입 금액 범위 입력")
    void invalidRange(String input) {
        Assertions.assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .hasMessage(PurchaseAmountExceptionMessage.OUT_OF_AMOUNT_RANGE.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001", "1100", "200001", "3001001", "40000111", "10000100"})
    @DisplayName("[Exception] 1000원 단위가 아닌 입력")
    void invalidAmountUnit(String input) {
        Assertions.assertThatThrownBy(() -> PurchaseAmountValidator.validate(input))
                .hasMessage(PurchaseAmountExceptionMessage.INVALID_AMOUNT_UNIT.getError());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "100000000", "11000", "220000", "3345000", "98765000", "10101000"})
    @DisplayName("[Success] 제한 길이 이내이고, 숫자로만 이루어져있고, 1000원 단위인 입력")
    void validAmount(String input) {
        Assertions.assertThatCode(() -> PurchaseAmountValidator.validate(input))
                .doesNotThrowAnyException();
    }
}
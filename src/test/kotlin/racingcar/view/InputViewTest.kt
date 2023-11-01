package racingcar.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.config.ExceptionMessage.INVALID_INTEGER

class InputViewTest {
    private lateinit var inputView: InputView

    @BeforeEach
    fun setUp() {
        inputView = InputView()
    }

    // inputCars test
    @ParameterizedTest
    @CsvSource(
        "pobi,woni,jun : pobi,woni,jun",
        "pobi, woni , jun : pobi,woni,jun", delimiter = ':'
    )
    fun `입력 값은 쉼표(,)를 기준으로 앞 뒤 공백을 제거한 값의 리스트로 반환한다`(input: String, expected: String) {
        val result = inputView.cars(input)
        Assertions.assertThat(result).isEqualTo(expected.split(','))
    }

    // inputTryCount test
    @ParameterizedTest
    @ValueSource(strings = ["abc", "-1", "${Integer.MAX_VALUE + 1}"])
    fun `숫자 입력 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException>(INVALID_INTEGER) {
            inputView.tryCount(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "4", "${Integer.MAX_VALUE}"])
    fun `Int 형 자연수를 문자열로 입력했을 시 해당 숫자를 Int 형으로 반환한다`(input: String) {
        val result = inputView.tryCount(input)
        val expected = Integer.parseInt(input)
        Assertions.assertThat(result).isEqualTo(expected)
    }
}
package racingcar.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    private lateinit var inputView: InputView
    private lateinit var inputCars: String
    private lateinit var inputTryCount: String

    @BeforeEach
    fun setUp() {
        inputView = InputView()
    }

    // test inputCars
    @Test
    fun `입력 값은 쉼표(,)를 기준으로 리스트로 반환한다`() {
        inputCars = "pobi,woni,jun"
        val inputList = listOf("pobi", "woni", "jun")
        val result = inputView.inputCars(inputCars)
        Assertions.assertThat(result).isEqualTo(inputList)
    }

    @Test
    fun `입력 값이 쉼표(,) 앞 뒤로 공백이 있다면 이를 제거하고 리스트로 반환한다`() {
        inputCars = "pobi, woni , jun"
        val inputList = listOf("pobi", "woni", "jun")
        val result = inputView.inputCars(inputCars)
        Assertions.assertThat(result).isEqualTo(inputList)
    }

    // test inputTryCount
    @Test
    fun `숫자가 아닌 문자열을 입력하면 예외를 던진다`() {
        inputTryCount = "abc"
        assertThrows<IllegalArgumentException>(
            "${Integer.MAX_VALUE} 이하의 자연수를 입력해주세요."
        ) {
            inputView.inputTryCount(inputTryCount)
        }
    }

    @Test
    fun `0 이하의 숫자를 입력하면 예외를 던진다`() {
        inputTryCount = "-1"
        assertThrows<IllegalArgumentException>(
            "${Integer.MAX_VALUE} 이하의 자연수를 입력해주세요."
        ) {
            inputView.inputTryCount(inputTryCount)
        }
    }

    @Test
    fun `Int 형의 최대값보다 큰 숫자를 입력하면 예외를 던진다`() {
        inputTryCount = "${Integer.MAX_VALUE + 1}" // 테스트를 위해 overflow 를 일부러 발생시킨다.
        assertThrows<IllegalArgumentException>(
            "${Integer.MAX_VALUE} 이하의 자연수를 입력해주세요."
        ) {
            inputView.inputTryCount(inputTryCount)
        }
    }

    @Test
    fun `Int 형 자연수를 문자열로 입력했을 시 해당 숫자를 Int 형으로 반환한다`() {
        inputTryCount = "${Integer.MAX_VALUE}"
        val result = inputView.inputTryCount(inputTryCount)
        Assertions.assertThat(result).isEqualTo(Integer.MAX_VALUE)
    }

}
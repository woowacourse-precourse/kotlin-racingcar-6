package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InputCarsTest {

    private lateinit var inputCars: InputCars
    private lateinit var input: String

    @BeforeEach
    fun setUp() {
        inputCars = InputCars()
    }

    @Test
    fun `입력 값은 쉼표(,)를 기준으로 리스트로 반환한다`() {
        input = "pobi,woni,jun"
        val inputList = listOf("pobi", "woni", "jun")
        val result = inputCars(input)
        assertThat(result).isEqualTo(inputList)
    }

    @Test
    fun `입력 값이 쉼표(,) 앞 뒤로 공백이 있다면 이를 제거하고 리스트로 반환한다`() {
        input = "pobi, woni , jun"
        val inputList = listOf("pobi", "woni", "jun")
        val result = inputCars(input)
        assertThat(result).isEqualTo(inputList)
    }
}

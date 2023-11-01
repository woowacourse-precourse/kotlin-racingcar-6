package racingcar.view

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import racingcar.view.PlayerConsole.getValidCarNames
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class PlayerConsoleTest {

    private val outputCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputCaptor))
    }

    @AfterEach
    fun cleanUp() {
        System.setOut(System.out)
        Console.close()
    }

    private fun simulateInput(input: String) {
        val buffer = "$input\n".toByteArray()
        System.setIn(ByteArrayInputStream(buffer))
    }

    @Nested
    inner class GetValidCarNamesTest {
        @Test
        fun `getValidCarNames 테스트`() {
            simulateInput("car1,car2")
            val carNames = getValidCarNames()
            assertThat(outputCaptor.toString().trim()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
            assertThat(carNames).containsExactlyElementsOf(listOf("car1", "car2"))
        }

        @Test
        fun `getValidCarNames - 입력한 자동차 이름이 1자 미만이거나 5자를 초과하는 경우`() {
            val invalidInputs = listOf("", ",car", "car,RacingCar")

            invalidInputs.forEach { input ->
                simulateInput(input)
                val exception = assertThrows<IllegalArgumentException> { getValidCarNames() }
                assertThat(exception.message).isEqualTo("자동차 이름은 한 글자 이상, 5글자 이하로 입력해 주세요.")
                Console.close()
            }
        }

        @Test
        fun `getValidCarNames - 입력한 자동차 이름에 공백 또는 특수 문자가 포함되어 있는 경우`() {
            val invalidInputs = listOf(" ", " car", "car1, car2", "car,$#@%")

            invalidInputs.forEach { input ->
                simulateInput(input)
                val exception = assertThrows<IllegalArgumentException> { getValidCarNames() }
                assertThat(exception.message).isEqualTo("문자와 숫자만 입력해 주세요.")
                Console.close()
            }
        }
    }
}
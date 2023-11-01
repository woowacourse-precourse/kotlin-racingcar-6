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

    @Nested
    inner class GetValidMoveCountTest {
        @Test
        fun `getValidMoveCount 테스트`() {
            simulateInput("12")
            val moveCount = PlayerConsole.getValidMoveCount()
            assertThat(outputCaptor.toString().trim()).isEqualTo("시도할 횟수는 몇 회인가요?")
            assertThat(moveCount).isEqualTo(12)
        }

        @Test
        fun `getValidMoveCount - 입력값이 비어 있을 때`() {
            val invalidInputs = listOf("", " ", "  ")

            invalidInputs.forEach { input ->
                simulateInput(input)
                val exception = assertThrows<IllegalArgumentException> { PlayerConsole.getValidMoveCount() }
                assertThat(exception.message).isEqualTo("입력값이 비어 있습니다.")
                Console.close()
            }
        }

        @Test
        fun `getValidMoveCount - 입력값이 숫자가 아닐 때`() {
            val invalidInputs = listOf(" 12", "abc")

            invalidInputs.forEach { input ->
                simulateInput(input)
                val exception = assertThrows<IllegalArgumentException> { PlayerConsole.getValidMoveCount() }
                assertThat(exception.message).isEqualTo("숫자만 입력해 주세요.")
                Console.close()
            }
        }

        @Test
        fun `getValidMoveCount - 입력값의 범위가 조건과 다를 때`() {
            val invalidInputs = listOf("0", "99999999999")

            invalidInputs.forEach { input ->
                simulateInput(input)
                val exception = assertThrows<IllegalArgumentException> { PlayerConsole.getValidMoveCount() }
                assertThat(exception.message).isEqualTo("입력 숫자의 범위가 유효하지 않습니다.")
                Console.close()
            }
        }
    }
}
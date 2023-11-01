package racingcar.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class GameConsoleTest {

    private val outputCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputCaptor))
    }

    @Test
    fun `printPosition 출력 확인`() {
        val name = "car"
        val position = 3

        GameConsole.printPosition(name, position)

        Assertions.assertThat(outputCaptor.toString().trim()).isEqualTo("$name : ---")
    }

    @Test
    fun `printWinnerNames 출력 확인`() {
        val winnerNames = listOf("car1", "car2", "car3")

        GameConsole.printWinnerNames(winnerNames)

        Assertions.assertThat(outputCaptor.toString().trim()).isEqualTo("최종 우승자 : somin, woowa, test")
    }
}
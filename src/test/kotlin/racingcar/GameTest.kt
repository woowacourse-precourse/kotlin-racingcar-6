package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import racingcar.game.Dice
import racingcar.game.RacingGame
import racingcar.io.UserInterface
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class GameTest {

    private val originalSystemOut = System.out
    private val outputStream = ByteArrayOutputStream()


    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown() {

        System.setOut(originalSystemOut)
    }

    @Test
    fun `이름과 진행도 정상 출력 기능 확인`() {
        val ui = UserInterface()

        ui.printPlayerProgress("aaa",5)

        val expectedOutput = "aaa : -----"

        val consoleOutput = outputStream.toString().trim()

        assertThat(consoleOutput).isEqualTo(expectedOutput)
    }
}
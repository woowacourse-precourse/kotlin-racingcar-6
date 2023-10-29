package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import racingcar.game.Dice
import racingcar.game.RacingGame
import racingcar.io.UserInterface
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest

class GameTest: NsTest() {

    private val originalSystemOut = System.out
    private val outputStream = ByteArrayOutputStream()


    @AfterEach
    fun tearDown() {

        System.setOut(originalSystemOut)
    }

    @Test
    fun `이름과 진행도 정상 출력 기능 확인`() {
        System.setOut(PrintStream(outputStream))
        val ui = UserInterface()

        ui.printPlayerProgress("aaa", 5)

        val expectedOutput = "aaa : -----"

        val consoleOutput = outputStream.toString().trim()

        assertThat(consoleOutput).isEqualTo(expectedOutput)
    }

    @Test
    fun `우승자 출력 확인1`() {
        System.setOut(PrintStream(outputStream))
        val ui = UserInterface()
        ui.printWinners(listOf("aaa","bbb","ccc"))

        val expectedOutput = "최종 우승자 : aaa, bbb, ccc"
        val consoleOutput = outputStream.toString().trim()

        assertThat(consoleOutput).isEqualTo(expectedOutput)
    }

    @Test
    fun `우승자 출력 확인2`() {
        System.setOut(PrintStream(outputStream))
        val ui = UserInterface()
        ui.printWinners(listOf("aaa"))

        val expectedOutput = "최종 우승자 : aaa"
        val consoleOutput = outputStream.toString().trim()

        assertThat(consoleOutput).isEqualTo(expectedOutput)
    }

    @Test
    fun `모두 한칸도 진행하지 않았을 경우`() {
        assertRandomNumberInRangeTest(
            {
                run("aaa,bbb", "1")
                assertThat(output()).contains("aaa : ", "bbb : ", "최종 우승자 : aaa, bbb")
            },
            STOP, STOP
        )

    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
package racingcar.view

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ResultViewTest {
    private val outputStream = ByteArrayOutputStream()
    private val printStream = PrintStream(outputStream)

    @BeforeEach
    fun setUp() {
        System.setOut(printStream)
    }

    @AfterEach
    fun tearDown() {
        System.setOut(null)
    }

    @Test
    fun `최종 승자가 한 명일 때 승자 출력`() {
        val carStatus = mutableMapOf("CAR1" to "---", "CAR2" to "--", "CAR3" to "--")
        val resultView = ResultView()
        resultView.printWinner(carStatus)

        val expectedOutput = "최종 우승자 : CAR1"
        assertEquals(expectedOutput, outputStream.toString().trim())
    }

    @Test
    fun `최종 승자가 두 명 이상일 때 모든 승자를 출력`() {
        val carStatus = mutableMapOf("CAR1" to "---", "CAR2" to "---", "CAR3" to "--")
        val resultView = ResultView()
        resultView.printWinner(carStatus)

        val expectedOutput = "최종 우승자 : CAR1, CAR2"
        assertEquals(expectedOutput, outputStream.toString().trim())
    }
}

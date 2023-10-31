package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

class OutputViewTest {

    private lateinit var standardOut: PrintStream
    private lateinit var captor: OutputStream

    @BeforeEach
    fun init() {
        standardOut = System.out
        captor = ByteArrayOutputStream()
        System.setOut(PrintStream(captor))
    }

    @AfterEach
    fun printOutput() {
        System.setOut(standardOut)
        println(output())
    }

    fun output(): String {
        return captor.toString().trim { it <= ' ' }
    }

    @Test
    fun `printInputGuideCarNameList 정상 출력`() {
        val view = OutputView()
        view.printInputGuideCarNameList()
        assertThat(output()).isEqualTo(OutputView.Message.INPUT_GUIDE_CAR_NAME_LIST.text)
    }

    @Test
    fun `printInputGuidePlayCount 정상 출력`() {
        val view = OutputView()
        view.printInputGuidePlayCount()
        assertThat(output()).isEqualTo(OutputView.Message.INPUT_GUIDE_PLAY_COUNT.text)
    }

    @Test
    fun `printResultMessage 정상 출력`() {
        val view = OutputView()
        view.printResultMessage()
        assertThat(output()).contains(OutputView.Message.PLAY_RESULT.text)
    }

    @Test
    fun `printPlayStatus 정상 출력`() {
        val view = OutputView()
        val result = "게임 결과"
        view.printPlayStatus(result)
        assertThat(output()).isEqualTo(result)
    }

    @Test
    fun `printResultWinner 정상 출력`() {
        val view = OutputView()
        val winnerList = listOf("1", "2")
        view.printResultWinner(winnerList)
        val outputMessage = output()
        assertThat(outputMessage).contains(winnerList)
    }
}
package racingcar

import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.view.OutputView
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class PrintTest {
    private lateinit var outputStreamCaptor: ByteArrayOutputStream
    private val outputView = OutputView()
    @BeforeEach
    fun setUp() {
        this.outputStreamCaptor = ByteArrayOutputStream()
    }

    @Test
    fun `게임 시작 문구 출력 검증`() {
        System.setOut(PrintStream(outputStreamCaptor))

        outputView.printInputRacingcarName()

        val output = outputStreamCaptor.toString()
        AssertionsForClassTypes.assertThat(output).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }
}
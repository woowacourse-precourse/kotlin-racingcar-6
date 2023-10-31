package racingcar

import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.model.Winner
import racingcar.view.OutputView
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class PrintTest {
    private lateinit var outputStreamCaptor: ByteArrayOutputStream
    private val outputView = OutputView()
    private val winner = Winner()

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

    @Test
    fun `시도할 횟수를 묻는 문구 출력`() {
        System.setOut(PrintStream(outputStreamCaptor))

        outputView.printTryNumber()

        val output = outputStreamCaptor.toString()
        AssertionsForClassTypes.assertThat(output).contains("시도할 횟수는 몇 회인가요?")
    }

    @Test
    fun `실행 결과 출력이 올바른지 검증`() {
        System.setOut(PrintStream(outputStreamCaptor))

        val input = mutableMapOf(
            "Car1" to 3,
            "Car2" to 2,
            "Car3" to 4
        )
        outputView.printCarScore(input)
        val output = outputStreamCaptor.toString()
        AssertionsForClassTypes.assertThat(output).contains(
            "Car1 : ---\n" +
            "Car2 : --\n" +
            "Car3 : ----"
        )
    }

    @Test
    fun `최종 우승자 출력`() {
        System.setOut(PrintStream(outputStreamCaptor))
        val carScore = mutableMapOf(
            "Car1" to 3,
            "Car2" to 2,
            "Car3" to 4
        )
        val winner = winner.calculateWinner(carScore)
        outputView.printWinner(winner)

        val output = outputStreamCaptor.toString()
        AssertionsForClassTypes.assertThat(output).contains("최종 우승자 : Car3")
    }

    @Test
    fun `최종 우승자 2명 이상 출력`() {
        System.setOut(PrintStream(outputStreamCaptor))
        val carScore = mutableMapOf(
            "Car1" to 4,
            "Car2" to 2,
            "Car3" to 4
        )
        val winner = winner.calculateWinner(carScore)
        outputView.printWinner(winner)

        val output = outputStreamCaptor.toString()
        AssertionsForClassTypes.assertThat(output).contains("최종 우승자 : Car1, Car3")
    }
}
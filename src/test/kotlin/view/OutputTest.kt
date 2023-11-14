package view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.view.OutputView
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {
    private val outputView = OutputView()
    private val originalOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }

    @Test
    fun `startCommand 메서드가 올바른 메시지를 출력하는지 확인`() {
        // When
        outputView.startCommand()

        // Then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    @Test
    fun `getCountCommand 메서드가 올바른 메시지를 출력하는지 확인`() {
        // When
        outputView.getCountCommand()

        // Then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("시도할 횟수는 몇번인가요?")
    }

    @Test
    fun `winnerOutput 메서드가 올바른 메시지를 출력하는지 확인`() {
        // When
        outputView.winnerOutput("car")

        // Then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("최종 우승자 : car")
    }

    @Test
    fun `resultOutput 메서드가 올바른 메시지를 출력하는지 확인`() {
        // When
        outputView.resultOutput("car", 3)

        // Then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("car : ---")
    }
}

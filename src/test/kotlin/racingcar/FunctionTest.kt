package racingcar

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.model.Constants
import racingcar.view.OutputView
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class FunctionTest {
    val outputStreamCaptor = ByteArrayOutputStream()
    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(System.out)
    }

    @Test
    fun `각 게임 결과 반환 테스트`() {
        val cars = listOf("bmw", "lexus", "lambo")
        val progress = listOf("--", "---", "-")

        OutputView().eachRacingResult(cars, progress)

        val expectedOutput = """
            bmw : --
            lexus : ---
            lambo : -
        """.trimIndent()


        assertEquals(expectedOutput, outputStreamCaptor.toString().trim())
    }

    @Test
    fun `우승자 반환 테스트`() {
        val cars = listOf("bmw", "lexus")

        OutputView().winner(cars)

        val expectedOutput = """
            최종 우승자 : bmw, lexus
        """.trimIndent()


        assertEquals(expectedOutput, outputStreamCaptor.toString().trim())
    }


}
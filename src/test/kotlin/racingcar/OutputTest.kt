package racingcar

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.view.Output
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputTest {
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
        Output().eachRacingResult(cars, progress)
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
        Output().winner(cars)
        val expectedOutput = """
            최종 우승자 : bmw, lexus
        """.trimIndent()
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim())
    }


}
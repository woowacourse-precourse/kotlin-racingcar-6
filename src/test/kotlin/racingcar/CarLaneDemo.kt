package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CarLaneDemo {
    private var cars:List<String> = listOf("a","b","c")
    private var carLane = CarLane(cars)

    companion object {
        private val standardOut = System.out
        private val outputStreamCaptor = ByteArrayOutputStream()
        private var output = outputStreamCaptor.toString().trim()
        @BeforeAll
        fun setUpStream() {
            System.setOut(PrintStream(outputStreamCaptor))
        }

        @AfterAll
        fun tearDown() {
            System.setOut(standardOut)
        }
    }

    @Test
    fun `1번의 이동기회마다 모든 자동차의 경주 결과를 보여주는지 확인`() {
        carLane.runCars()
        carLane.showLap()

        Assertions.assertThat(output.contains("a :\nb :\nc :\n"))
    }

    @Test
    fun `모두 같은 거리를 갔을 때 모두를 우승자로 판단하는지 확인`() {
        val input = carLane.judgeWinner()

        assertEquals(listOf("a","b","c"),input)
    }
}
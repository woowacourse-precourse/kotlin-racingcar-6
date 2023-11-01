package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Report

class ReportTest {
    private val reporter = Report()

    @Test
    fun `어떤 자동차도 출발하지 않은 경우`() {
        val input = mapOf(Pair("car1", 0), Pair("car2", 0), Pair("car3", 0))
        val winner = reporter.checkWinner(input)
        val result = reporter.raceResult(winner)
        assertThat(winner).isEmpty()
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `모든 자동차들이 동일하게 전진한 경우`() {
        val input = mapOf(Pair("car1", 1), Pair("car2", 1), Pair("car3", 1))
        val result = reporter.checkWinner(input)
        assertThat(result).isEqualTo("car1, car2, car3")
    }
}
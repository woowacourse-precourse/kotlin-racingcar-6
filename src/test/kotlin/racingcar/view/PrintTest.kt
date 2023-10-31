package racingcar.view

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class PrintTest {
    @Test
    fun `joinToString 메서드 확인`() {
        val winnerList = listOf("im", "win", "wow")
        val winner = winnerList.joinToString(", ")
        println(winner)
        assertThat(winner).isEqualTo("im, win, wow")
    }
}
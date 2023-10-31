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

    @Test
    fun `repeat 와 get 을 통한 데이터 확인`() {
        val playerList = listOf("minsu", "test1", "test2")
        val distanceList = listOf("--", "----", "-")
        val testPlayerList = listOf("minsu", "test1", "test2")
        val testDistanceList = listOf("--", "----", "-")
        repeat(playerList.size) { index ->
            assertThat(playerList[index]).isEqualTo(testPlayerList[index])
            assertThat(distanceList[index]).isEqualTo(testDistanceList[index])
        }
    }
}
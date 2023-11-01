package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RefereeTest{
    private lateinit var referee: Referee
    @BeforeEach
    fun setUp() {
        referee = Referee()
    }

    @Test
    fun `최고점을 찾기`() {
        val carScore = mutableListOf(
            Pair("pobi", 0),
            Pair("nana", 1),
            Pair("ddubi", 2),
            Pair("po", 20),
        )
        val maxScore = 20

        val result = referee.findMaxScore(carScore)

        assertEquals(maxScore, result)
    }

    @Test
    fun `최고점에 따라 우승자 찾기 1명일 때`() {
        val carScore = mutableListOf(
            Pair("pobi", 0),
            Pair("nana", 1),
            Pair("ddubi", 2),
            Pair("po", 20),
        )
        val winner = listOf("po")

        val result = referee.findWinner(carScore, 20)

        assertEquals(winner, result)
    }

    @Test
    fun `최고점에 따라 우승자 찾기 2명이상 일 때`() {
        val carScore = mutableListOf(
            Pair("pobi", 0),
            Pair("nana", 1),
            Pair("ddubi", 20),
            Pair("po", 20),
        )
        val winners = listOf("ddubi", "po")

        val result = referee.findWinner(carScore, 20)

        assertEquals(winners, result)
    }

    @Test
    fun `우승자 출력을 정상적으로 했는지 1명일 때`() {
        val winner = listOf("woowa")
        val input = winner.joinToString()

        val result = referee.printWinner(winner)

        assertEquals("최종 우승자 : $input", result)
    }

    @Test
    fun `우승자 출력을 정상적으로 했는지 2명이상 일 때`() {
        val winners = listOf("woowa", "tech", "!@#")
        val input = winners.joinToString()

        val result = referee.printWinner(winners)

        assertEquals("최종 우승자 : $input", result)
    }
}
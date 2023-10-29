package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingBoardTest {
    @Test
    fun `racerList 가 비어있으면 안됩니다`() {
        assertThrows<IllegalArgumentException> {
            RacingBoard(listOf())
        }
    }

    @Test
    fun `getResult 우승자만 가져옵니다`() {
        val winner = Car("win")
        winner.pos = 3
        val racerList = listOf(Car("loser"), winner)
        RacingBoard(racerList).getResult()
        assertThat(RacingBoard(racerList).getResult()).isEqualTo(listOf(winner))
    }

    @Test
    fun `getResult 우승자가 여러명이어도 가능합니다`() {
        val winner = Car("win")
        winner.pos = 3
        val racerList = listOf(Car("loser"), winner, winner)
        RacingBoard(racerList).getResult()
        assertThat(RacingBoard(racerList).getResult()).isEqualTo(listOf(winner, winner))
    }

    @Test
    fun `getPlayStatus 현재 경기 상태를 출력`() {
        val winner = Car("win")
        winner.pos = 3
        val racerList = listOf(Car("loser"), winner)

        val status = RacingBoard(racerList).getPlayStatus()
        assertThat(status).isEqualTo("loser : \n" + "win : ---")
    }
}
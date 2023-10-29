package racingcar.model

import org.assertj.core.api.Assertions
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
    fun `getResult로 우승자만 가져옵니다`() {
        val winner = Car("win")
        winner.pos = 3
        val racerList = listOf(Car("loser"), winner)
        RacingBoard(racerList).getResult()
        Assertions.assertThat(RacingBoard(racerList).getResult()).isEqualTo(listOf(winner))
    }

    @Test
    fun `getResult는 우승자가 여러명이어도 가능합니다`() {
        val winner = Car("win")
        winner.pos = 3
        val racerList = listOf(Car("loser"), winner, winner)
        RacingBoard(racerList).getResult()
        Assertions.assertThat(RacingBoard(racerList).getResult()).isEqualTo(listOf(winner, winner))
    }

    @Test
    fun `문자열로 출력 확인합니다`() {
        val racerList = listOf(Car("1"), Car("2"), Car("3"))
        Assertions.assertThat(RacingBoard(racerList).toString()).isEqualTo(racerList.joinToString("\n"))
    }
}
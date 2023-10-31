package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingBoardTest {
    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }

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

    @Test
    fun `play 경기를 진행합니다`() {
        val racerList = listOf(Car("111"), Car("222"), Car("333"))
        val board = RacingBoard(racerList)

        Assertions.assertRandomNumberInRangeTest(
            {
                board.play()
                assertThat(racerList.map { car: Car -> car.pos }).isEqualTo(listOf(1, 0, 1))
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }
}
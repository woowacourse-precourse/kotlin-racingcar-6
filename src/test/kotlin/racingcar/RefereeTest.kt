package racingcar

import camp.nextstep.edu.missionutils.test.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class RefereeTest {
    @Test
    fun `객체 초기화`() {
        assertDoesNotThrow {
            val referee = Referee(
                listOf("a", "b", "c"),
                3,
                {},
            )
        }
    }

    @Test
    fun `우승자 조회 테스트`() {
        val referee = Referee(
            listOf("a", "b", "c"),
            1,
            {},
        )
        Assertions.assertRandomNumberInRangeTest(
            {
                val winners = referee.getWinners()
                assertTrue(winners.size == 1 && winners.elementAt(0).name == "a")
            },
            4,
            0,
            0,
        )
    }
}

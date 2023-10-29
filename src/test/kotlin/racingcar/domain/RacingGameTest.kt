package racingcar.domain

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class RacingGameTest {

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }

    @Test
    fun `start - 모든라운드의 결과가 반환된다`() {

        assertRandomNumberInRangeTest(
            {
                val cars = listOf(Car("car1"), Car("car2"))
                val racingGame = RacingGame(cars, 3)
                val roundResults = racingGame.start()
                assertEquals(roundResults[0]["car1"], 1)
                assertEquals(roundResults[0]["car2"], 1)
                assertEquals(roundResults[1]["car1"], 1)
                assertEquals(roundResults[1]["car2"], 2)
                assertEquals(roundResults[2]["car1"], 1)
                assertEquals(roundResults[2]["car2"], 3)
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }
}

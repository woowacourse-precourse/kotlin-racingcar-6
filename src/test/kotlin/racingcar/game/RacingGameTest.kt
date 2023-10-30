package racingcar.game

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    fun `랜덤값에 따른 자동차 전진`() {
        assertRandomNumberInRangeTest(
            {
                val cars = listOf(
                    Car("Car1"),
                    Car("Car2"),
                    Car("Car3"),
                )
                RacingGame.moveCarsRandomly(cars)
                assertEquals(
                    cars,
                    listOf(
                        Car("Car1", 0),
                        Car("Car2", 1),
                        Car("Car3", 1),
                    )
                )
            },
            3, 4, 8
        )

    }

    @Test
    fun `랜덤값에 따른 전진 가능 유무`() {
        assertRandomNumberInRangeTest(
            {
                assertEquals(RacingGame.isCarMovable(), true)
            },
            4
        )
    }

    @Test
    fun `우승한 자동차 선택`() {
        val winnerCar1 = Car("Car1", 3)
        val winnerCar2 = Car("Car2", 3)
        val looserCar = Car("Car3", 2)
        val cars = listOf(winnerCar1, winnerCar2, looserCar)
        val result = RacingGame.chooseWinners(cars)

        assertEquals(result, listOf(winnerCar1, winnerCar2))
    }
}
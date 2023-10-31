package racingcar.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import racingcar.car.Car
import racingcar.car.MoveStrategy

class RoundTest {
    private val movableStrategy =  object : MoveStrategy {
        override fun isMovable(): Boolean {
            return true
        }
    }
    private val notMovableStrategy = object : MoveStrategy{
        override fun isMovable(): Boolean {
            return false
        }
    }

    @Test
    fun `1번의 round가 진행된 후 결과를 출력한다`() {
        // given
        val cars = listOf(Car("pobi", notMovableStrategy), Car("woni", movableStrategy))
        val round = Round(cars)

        // when
        round.start()

        // then
        assertThat(round.result()).contains("pobi : ", "woni : -")
    }
}
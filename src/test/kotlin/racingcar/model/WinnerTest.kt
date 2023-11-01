package racingcar.model

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

import racingcar.car.Car

class WinnerTest {
    @Test
    fun `Winner 의 toString은 우승자의 이름을 반환한다`() {
        val cars: List<Car> = listOf(Car("murjune"), Car("pobi"), Car("crong"))
        val winner = Winner(cars)
        assertThat(winner.toString())
            .isEqualTo("최종 우승자 : murjune, pobi, crong")
    }
}
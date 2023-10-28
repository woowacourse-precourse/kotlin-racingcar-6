package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("자동차 경주의 자동차를 이동시키는 RacingCarMover에서")
class RacingCarMoverTest {
    private val carMover = RacingCarMover()

    @Test
    @DisplayName("자동차 수가 2 미만일 경우 IllegalArgumentException이 생긴다")
    fun carsLessThenTwo() {
        //give
        val racingCars = RacingCars(listOf("pow"))
        //when
        //then
        Assertions.assertThatThrownBy { carMover.moveRacingCars(racingCars) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("자동차의 이름의 길이가 5를 초과할 경우 IllegalArgumentException이 생긴다")
    fun carNameLengthGreaterThanFive() {
        //give
        val racingCars = RacingCars(listOf("pow123"))
        //when
        //then
        Assertions.assertThatThrownBy { carMover.moveRacingCars(racingCars) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }
}
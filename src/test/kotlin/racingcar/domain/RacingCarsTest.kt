package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("RacingCars 에서")
class RacingCarsTest {

    @Test
    @DisplayName("자동차 경주의 결과를 반환한다")
    fun calculateWinner() {
        //give
        val car1 = "i30"
        val car2 = "911"
        val car3 = "718"
        val racingCars = RacingCars(listOf(car1, car2, car3))
        val randomNumbers = listOf(5, 1, 2)
        //when
        racingCars.moveRacingCars(randomNumbers)
        //then
        val result = racingCars.calculateWinner()
        Assertions.assertThat(result.toWinnerNamesGameResult()).contains(car1)
            .doesNotContain(car2)
            .doesNotContain(car3)
    }

    @Test
    @DisplayName("자동차 경주에 참가한 자동차의 수를 반환한다")
    fun racingCarsSize() {
        //give
        val racingCars = RacingCars(listOf("i30", "911", "718"))
        //when
        //then
        Assertions.assertThat(racingCars.racingCarsSize()).isEqualTo(3)

    }
}
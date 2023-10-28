package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("자동차 경주 결과를 비교하기 위한 RacingCarsComparator에서")
class RacingCarsComparatorTest {
    private val racingCarsComparator = RacingCarsComparator()

    @Test
    @DisplayName("단일 우승자의 경우 크기가 1인 list를 받을 수 있다")
    fun soleWinner() {
        //given
        val racingCars = RacingCars(listOf("911", "718"))
        racingCars.loadRacingCars()[0].addForwardCount()
        //when
        val result = racingCarsComparator.calculateWinner(racingCars)
        //then
        Assertions.assertThat(result.getWinners().size).isEqualTo(1)
    }

    @Test
    @DisplayName("공동 우승자가 2명일 경우 크기가 2인 list를 받을 수 있다")
    fun jointWinner() {
        //given
        val racingCars = RacingCars(listOf("911", "718"))
        racingCars.loadRacingCars()[0].addForwardCount()
        racingCars.loadRacingCars()[1].addForwardCount()
        //when
        val result = racingCarsComparator.calculateWinner(racingCars)
        //then
        Assertions.assertThat(result.getWinners().size).isEqualTo(2)
    }
}
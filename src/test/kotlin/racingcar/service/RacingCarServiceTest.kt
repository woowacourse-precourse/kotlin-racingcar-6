package racingcar.service

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.RacingCars
import racingcar.repository.RacingCarsRepository
import racingcar.util.RandomNumberGenerator

@DisplayName("서비스를 하는 RacingCarService에서")
class RacingCarServiceTest {
    private val racingCarService = RacingCarService(RandomNumberGenerator(), RacingCarsRepository())

    @Test
    @DisplayName("단일 우승자의 경우 우승자의 이름만 출력한다")
    fun soleWinner() {
        //given
        val winner = "911"
        val loser = "718"
        val racingCars = RacingCars(listOf(winner, loser))
        racingCars.moveRacingCars(listOf(5, 2))
        racingCarService.saveRacingCars(racingCars)
        //when
        val result = racingCarService.calculateRacingResult()
        //then
        Assertions.assertThat(result.toWinnerNamesGameResult()).contains(winner).doesNotContain(loser)
    }

    @Test
    @DisplayName("공동 우승자가 2명일 경우 크기가 2인 list를 받을 수 있다")
    fun jointWinner() {
        //given
        val winner1 = "911"
        val winner2 = "718"
        val racingCars = RacingCars(listOf(winner1, winner2))
        racingCars.moveRacingCars(listOf(5, 6))
        racingCarService.saveRacingCars(racingCars)
        //when
        val result = racingCarService.calculateRacingResult()
        //then
        Assertions.assertThat(result.toWinnerNamesGameResult()).contains(winner1, winner2)
    }
}
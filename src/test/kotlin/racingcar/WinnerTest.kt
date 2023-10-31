package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.model.RacingCar
import racingcar.model.WinnerGenerator

class WinnerTest {

    @Test
    fun `우승자 출력 여부 테스트`() {
        val winnerGenerator = WinnerGenerator()
        val racingCar = RacingCar("테스트1", "--")
        val racingCar2 = RacingCar("테스트2", "---")
        val list = winnerGenerator.win(mutableListOf(racingCar, racingCar2))
        Assertions.assertThat(list.getWinners()).isEqualTo("테스트2")
    }

    @Test
    fun `우승자는 한 명 이상일 수 있으며, 쉼표로 구분한다`() {
        val winnerGenerator = WinnerGenerator()
        val racingCar = RacingCar("테스트1", "---")
        val racingCar2 = RacingCar("테스트2", "---")
        val racingCar3 = RacingCar("테스트3", "--")
        val list = winnerGenerator.win(mutableListOf(racingCar, racingCar2, racingCar3))
        Assertions.assertThat(list.getWinners()).isEqualTo("테스트1, 테스트2")
    }
}

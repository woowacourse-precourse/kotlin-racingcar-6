package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Game
import racingcar.view.InputView

class RacingTest {
    @Test
    fun `자동차 전진 결과 출력`() {
        val car = Car("test")
        car.move(4)
        assertThat(car.getResult()).isEqualTo("test : -")
        car.move(3)
        assertThat(car.getResult()).isEqualTo("test : -")
    }

    @Test
    fun `최종 우승자 출력`() {
        val game = Game()
        val input = mapOf("test1" to 2, "test2" to 6, "test3" to 4)
        val winner = game.awardWinner(input)
        val result = winner.joinToString(",")
        assertThat(result).isEqualTo("test2")
    }

    @Test
    fun `공동 우승자 출력`() {
        val game = Game()
        val input = mapOf("test1" to 2, "test2" to 6, "test3" to 6)
        val winner = game.awardWinner(input)
        val result = winner.joinToString(",")
        assertThat(result).isEqualTo("test2,test3")
    }
}
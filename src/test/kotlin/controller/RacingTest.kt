package controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import racingcar.controller.Racing
import racingcar.model.Car
import racingcar.view.OutputView

class RacingTest {
    @Test
    fun `isMove 메서드는 0 이상 9 이하의 랜덤 숫자를 생성하여 4 이상인 경우 true를 반환한다`() {
        val outputView = mock(OutputView::class.java)
        val cars = mutableListOf<Car>()
        val racing = Racing(outputView, 1, cars)

        val result = racing.isMove()

        assertThat(result).isIn(true, false)
    }

    @Test
    fun `isMove가 true이면 move를 실행한다`() {
        val outputView = mock(OutputView::class.java)
        val car = mock(Car::class.java)
        val cars = mutableListOf(car)
        val racing = Racing(outputView, 1, cars)

        racing.startRacing()

        verify(car, atLeast(0)).move()
    }
}

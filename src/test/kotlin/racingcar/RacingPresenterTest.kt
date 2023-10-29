package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class RacingPresenterTest {

    @Test
    fun `이름 여러개를 입력했을 때 이름이 5자 이하면 성공적으로 생성`() {
        val presenter = RacingPresenter()
        val input = "pobi,hello"
        assertDoesNotThrow {
            presenter.createRacingCarsOrThrow(input)
        }
    }

    @Test
    fun `이름을 하나만 입력했을 때 이름이 5자 이하면 성공적으로 생성`() {
        val presenter = RacingPresenter()
        val input = "hello"
        assertDoesNotThrow {
            presenter.createRacingCarsOrThrow(input)
        }
    }

    @Test
    fun `이름이 5자 초과면 예외를 던짐`() {
        val presenter = RacingPresenter()
        val input = "pobigood,hello"
        assertThrows<IllegalArgumentException> {
            presenter.createRacingCarsOrThrow(input)
        }
    }

    @Test
    fun `레이싱 카들이 랜덤 값에 따라 움직이거나 움직이지 않음`() {
        val presenter = RacingPresenter()
        val input = "pobi,hello"
        presenter.createRacingCarsOrThrow(input)

        assertRandomNumberInRangeTest(
            {
                presenter.moveRacingCars()
                val cars = presenter.racingCars
                val movingCounts = cars.map { it.movingCount }
                Assertions.assertThat(movingCounts).contains(1, 0)
            },
            MOVING_FORWARD, STOP
        )
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
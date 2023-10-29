package racingcar

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
}
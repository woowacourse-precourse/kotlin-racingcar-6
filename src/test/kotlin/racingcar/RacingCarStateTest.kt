package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.MovementState
import racingcar.domain.RacingState

class RacingCarStateTest {

    companion object {
        private lateinit var racingState: RacingState

        @BeforeAll
        @JvmStatic
        fun setUp() {
            val carList = listOf(
                Car("pobi", 1),
                Car("woni", 2),
                Car("jun", 3)
            )
            racingState = RacingState(carList)
        }
    }

    @Test
    fun `숫자가 4 이상일 때 움직임 나오는지`() {
        val method = racingState.javaClass
            .getDeclaredMethod("determineMovement", Int::class.java).apply {
                isAccessible = true
            }
        val received = method(racingState, 6)
        val expected = MovementState.MOVE
        Assertions.assertThat(received).isEqualTo(expected)
    }

    @Test
    fun `숫자가 4 미만일 때 멈춤이 나오는지`() {
        val method = racingState.javaClass
            .getDeclaredMethod("determineMovement", Int::class.java).apply {
                isAccessible = true
            }
        val received = method(racingState, 3)
        val expected = MovementState.STOP
        Assertions.assertThat(received).isEqualTo(expected)
    }

    @Test
    fun `자동차의 움직임 결과 확인`() {
        val method = racingState.javaClass
            .getDeclaredMethod("getMovementResult").apply {
                isAccessible = true
            }
        val received = method(racingState)
        val expected = "pobi : -\n" + "woni : --\n" + "jun : ---" + "\n"
        Assertions.assertThat(received).isEqualTo(expected)
    }

    @Test
    fun `자동차의 움직임 잘못된 결과 확인`() {
        val method = racingState.javaClass
            .getDeclaredMethod("getMovementResult").apply {
                isAccessible = true
            }
        val received = method(racingState)
        val expected = "pobi -\n" + "woni : --\n" + "jun : ---" + "\n"
        Assertions.assertThat(received).isNotEqualTo(expected)
    }

    @Test
    fun `승자 결과 확인`() {
        val received = racingState.getWinner()
        val expected = "최종 우승자 : jun"
        Assertions.assertThat(received).isEqualTo(expected)
    }
}
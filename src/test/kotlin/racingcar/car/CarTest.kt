package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.`in`
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = CarImpl()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `랜덤 숫자가 0~3일 경우 자동차가 멈추는지`(randomNumber: Int) {
        car.forwardOrStop(randomNumber)
        val result = car.currentPosition

        assertThat(STOP).isEqualTo(result)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤 숫자가 4~9일 경우 자동차가 진행하는지`(randomNumber: Int) {
        car.forwardOrStop(randomNumber)
        val result = car.currentPosition

        assertThat(FORWARD).isEqualTo(result)
    }

    companion object {
        private const val STOP = ""
        private const val FORWARD = "-"
    }
}

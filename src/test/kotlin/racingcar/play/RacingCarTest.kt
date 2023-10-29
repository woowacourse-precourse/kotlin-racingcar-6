package racingcar.play

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarTest {
    val testCar = RacingCar("test")
    @Test
    fun `값이 4이상일 때, 전진 테스트_값 3`() {
        testCar.move(3)
        assertThat(testCar.distance).isEqualTo(0)
    }

    @Test
    fun `값이 4이상일 때, 전진 테스트_값 4`() {
        testCar.move(4)
        assertThat(testCar.distance).isEqualTo(1)
    }
}
package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `name 1자 미만 5자 초과 예외 처리`() {
        assertThrows<IllegalArgumentException> { Car("123456") }
    }

    @Test
    fun `drive 실행 시 distance 1증가`() {
        val car = Car("test")
        val initDistanceLength = car.distanceLength
        car.drive()
        assertThat(car.distanceLength).isEqualTo(initDistanceLength + 1)
    }
}
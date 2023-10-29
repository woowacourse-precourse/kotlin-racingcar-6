package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class CarTest {
    @Test
    fun `move 메서드 입력되는 숫자가 4보다 작을 때`() {
        // Given
        val car = Car("test")

        // When
        car.move(3)

        // Then
        assertThat(car).extracting("distance").isEqualTo(0)
    }

    @Test
    fun `move 메서드 입력되는 숫자가 4 이상일 때`() {
        // Given
        val car = Car("test")

        // When
        car.move(4)

        // Then
        assertThat(car).extracting("distance").isEqualTo(1)
    }

    @Test
    fun `printResult 메서드 사용시 차가 두 번 움직였을 때`() {
        // Given
        val car = Car("test")
        val result = "test : --"

        // When
        car.move(4)
        car.move(4)

        // Then
        assertThat(car.printResult()).isEqualTo(result)
    }
}
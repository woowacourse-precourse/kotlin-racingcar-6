package racingcarTest

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.Car

class CarTest {

    @Test
    fun `move increments position if random number is 4 or greater`() {
        val car = Car("pobi")
        val initialPosition = car.position

        car.move()

        assertThat(car.position).isEqualTo(initialPosition + 1)
    }

    @Test
    fun `move does not increment position if random number is less than 4`() {
        val car = Car("woni")
        val initialPosition = car.position

        car.move()

        assertThat(car.position).isEqualTo(initialPosition)
    }

    @Test
    fun `toString displays car name and position`() {
        val car = Car("jun")
        car.move()

        assertThat(car.toString()).isEqualTo("jun : -")
    }
}

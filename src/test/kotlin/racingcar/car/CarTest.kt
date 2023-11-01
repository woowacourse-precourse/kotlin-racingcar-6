package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.generator.NumberGenerator

class CarTest {
    @Test
    fun `move()는 score가 4이상이면 position에 "-" 가 더해진다`() {
        val movableCar = Car("june", object : NumberGenerator {
            override fun generate() = 5
        })
        val immovableCar = Car("june", object : NumberGenerator {
            override fun generate() = 3
        })

        movableCar.move()
        immovableCar.move()

        assertThat(movableCar.position).isEqualTo("-")
        assertThat(immovableCar.position).isEqualTo("")
    }

    @Test
    fun `car의 toString 은 name을 반환`() {
        val car = Car("june")

        assertThat(car.toString()).isEqualTo("june")
    }
}
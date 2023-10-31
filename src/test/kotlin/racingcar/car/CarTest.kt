package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.generator.NumberGenerator

class CarTest {
    @Test
    fun `car의 score를 생성하는 방법을 바꿀 수 있다`() {
        val car = Car("june", object : NumberGenerator {
            override fun generate() = 5
        })

        assertThat(car.score).isEqualTo(5)
    }

    @Test
    fun `car의 toString 값은 차 이름이다`() {
        val car = Car("june")

        assertThat(car.toString()).isEqualTo("june")
    }

    @Test
    fun `car가 움직이면 position에 "-" 가 더해진다`() {
        val car = Car("june")

        car.move()

        assertThat(car.position).isEqualTo("-")
    }
}
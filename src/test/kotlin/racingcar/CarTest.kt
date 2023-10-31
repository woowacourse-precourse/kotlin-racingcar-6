package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `이름이 올바르게 저장되는가`() {
        val car = Car("Woowa")

        assertThat(car.name).isEqualTo("Woowa")
    }

    @Test
    fun `상태가 올바르게 저장되는가`() {
        val car = Car("Woowa", TestMoveStrategy(listOf(4, 2, 5, 6)), 2, 3)

        val result = mutableListOf<Int>()

        for (i in 1..4) {
            car.move()
            result.add(car.location)
        }
        assertThat(result).isEqualTo(listOf(5, 5, 7, 9))
    }
}
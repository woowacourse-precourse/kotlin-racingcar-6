package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun testJudgeNumber() {
        val car = Car("test")
        assertThat(car.judgeNumber(3)).isFalse()
        assertThat(car.judgeNumber(5)).isTrue()
        assertThat(car.judgeNumber(7)).isTrue()
    }

    @Test
    fun testUpdatePosition() {
        val car = Car("test")
        assertThat(car.getPositionNumber()).isEqualTo(0)
        car.updatePosition(true)
        assertThat(car.getPositionNumber()).isEqualTo(1)
        car.updatePosition(false)
        assertThat(car.getPositionNumber()).isEqualTo(1)
    }

    @Test
    fun testGetPosition() {
        val car = Car("test")
        car.updatePosition(true)
        assertThat(car.getPosition()).isEqualTo("-")
        car.updatePosition(true)
        assertThat(car.getPosition()).isEqualTo("--")
        car.updatePosition(false)
        assertThat(car.getPosition()).isEqualTo("--")
    }

    @Test
    fun getNameTest() {
        val car = Car("test")
        assertThat(car.getName()).isEqualTo("test")
    }
}
package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `Car 이름은 공백이면 안됩니다`() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }

    @Test
    fun `Car 이름은 5를 넘으면 안됩니다`() {
        assertThrows<IllegalArgumentException> {
            Car("123456")
        }
    }

    @Test
    fun `Car 의 처음 위치는 0 입니다`() {
        assertThat(Car("test").pos).isEqualTo(0)
    }

    @Test
    fun `Car는 요구사항에 맞게 문자열로 변환해야 합니다`() {
        assertThat(Car("test").toString()).isEqualTo("test : ")
        val car3 = Car("test")
        car3.pos = 3
        assertThat(car3.toString()).isEqualTo("test : ---")
    }
}
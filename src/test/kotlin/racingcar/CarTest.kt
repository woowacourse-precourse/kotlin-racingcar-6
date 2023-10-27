package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class CarTest {

    @Test
    fun `앞으로 2번 이동했을 때, 현재 위치가 2인지`() {
        val car = Car(name = "셀카")
        car.moveForward()
        car.moveForward()
        assertThat(car.currentPosition).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "sseung416", "12345"])
    fun `자동차 이름이 5글자 초과이거나 공백이 아닌지`(input: String) {
        assertEqualsThrowsMessage<IllegalArgumentException>(Car.Error.InvalidName) {
            Car(name = input)
        }
    }
}
package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car
import racingcar.model.CarName
import racingcar.model.Error
import racingcar.model.RaceParticipants

class CarTest {

    @Test
    fun `앞으로 2번 이동했을 때, 현재 위치가 2인지`() {
        val car = Car(name = CarName("셀카"))
        car.moveForward()
        car.moveForward()
        assertThat(car.distance).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "sseung416", "123451"])
    fun `자동차 이름이 5글자 초과이거나 공백이 아닌지`(input: String) {
        assertThatThrownBy { CarName(input) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Error.InvalidCarName.toString())
    }

    @Test
    fun `자동차 이름이 중복되는지`() {
        assertThatThrownBy { RaceParticipants.from("asdf,asdf") }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Error.DuplicatedCarName.toString())
    }
}
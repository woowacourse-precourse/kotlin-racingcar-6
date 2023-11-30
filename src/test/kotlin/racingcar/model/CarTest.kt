package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car.Companion.BLANK_NAME
import racingcar.model.Car.Companion.TOO_LONG_NAME

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["123456", "abcdef", "심지 자동차", "πøˆoi9"])
    fun `자동차의 이름이 5자 초과이면 예외를 던진다`(carName: String) {
        assertThrowsWithMessage(carName, TOO_LONG_NAME)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  ", "\n"])
    fun `자동차의 이름이 공백이나 빈 값이면 예외를 던진다`(carName: String) {
        assertThrowsWithMessage(carName, BLANK_NAME)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", " a ", "pobi", "woni", "jun", "simji"])
    fun `정상적인 자동차의 이름은 통과한다`(carName: String) {
        assertDoesNotThrow { Car(carName) }
    }


    private fun assertThrowsWithMessage(carName: String, message: String) {
        val exception = assertThrows<IllegalArgumentException> {
            Car(carName)
        }
        assertThat(exception.message).isEqualTo(message)
    }

}
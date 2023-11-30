package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car
import racingcar.model.Cars
import java.util.stream.Stream

class InputConverterTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\n"])
    fun `경주할 자동차 문자열이 공백이면 예외를 던진다`(inputCars: String) {
        val exception = assertThrows<IllegalArgumentException> { inputCars.toCars() }
        assertThat(exception.message).isEqualTo(INPUT_CARS_BLANK)
    }

    @ParameterizedTest
    @MethodSource("provideNormalInputCars")
    fun `입력받은 자동차들 문자열을 Cars 로 변환한다`(inputCars: String, expectedCars: Cars) {
        val result = inputCars.toCars()
        assertThat(result).isEqualTo(expectedCars)
    }

    companion object {
        @JvmStatic
        fun provideNormalInputCars(): Stream<Arguments> = Stream.of(
            Arguments.of(
                "pobi ,woni,jun",
                Cars(
                    listOf(
                        Car("pobi", 0),
                        Car("woni", 0),
                        Car("jun", 0),
                    )
                )
            ),
            Arguments.of(
                "pobi,woni,jun,simji",
                Cars(
                    listOf(
                        Car("pobi", 0),
                        Car("woni", 0),
                        Car("jun", 0),
                        Car("simji", 0),
                    )
                )
            ),
        )
    }

}
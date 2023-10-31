package racingcar.util

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class ValidationTest {

    private val validation: Validation = Validation

    @ParameterizedTest
    @ValueSource(strings = ["Car12", " j u n "])
    fun `자동차 이름이 1자 이상 5자인 경우`(carNames: String) {
        assertDoesNotThrow {
            validation.validateLength(carNames)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["Car123", " p o b i ", "", " "])
    fun `자동차 이름이 1자 미만 또는 5자 초과인 경우`(carNames: String) {
        assertThrows<IllegalArgumentException> {
            validation.validateLength(carNames)
        }
    }

    @ParameterizedTest
    @MethodSource("provideOneCar")
    fun `자동차가 1대인 경우`(cars: List<String>) {
        assertThrows<IllegalArgumentException> {
            validation.validateNumberOfCars(cars)
        }
    }

    @ParameterizedTest
    @MethodSource("provideDuplicateCars")
    fun `자동차 이름이 중복되는 경우`(cars: List<String>) {
        assertThrows<IllegalArgumentException> {
            validation.validateDuplicateOfCars(cars)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "10", "${Int.MAX_VALUE}"])
    fun `올바르게 이동 횟수를 입력한 경우`(round: String) {
        assertDoesNotThrow {
            validation.validateRound(round)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", (Int.MAX_VALUE.toLong() + 1).toString()])
    fun `1 미만의 수 또는 Int 범위를 초과하는 수를 입력한 경우`(round: String) {
        assertThrows<IllegalArgumentException> {
            validation.validateRound(round)
        }
    }

    companion object {
        @JvmStatic
        fun provideOneCar(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf("MyCar"))
        )

        @JvmStatic
        fun provideDuplicateCars(): Stream<Arguments> = Stream.of(
            Arguments.of(listOf("Car1", "Car 1", "Car1"))
        )
    }
}
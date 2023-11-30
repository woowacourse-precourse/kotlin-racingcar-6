package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.model.Cars.Companion.DUPLICATED_CARS
import java.util.stream.Stream

class CarsTest {

    @ParameterizedTest
    @MethodSource("provideDuplicatedCarNames")
    fun `자동차들에 중복된 이름이 있다면 에외를 던진다`(names: List<String>) {
        val exception = assertThrows<IllegalArgumentException> {
            Cars.withNames(*names.toTypedArray())
        }

        assertThat(exception.message).isEqualTo(DUPLICATED_CARS)
    }

    @ParameterizedTest
    @MethodSource("provideNormalCarNames")
    fun `정상적인 자동차들은 통과한다`(names: List<String>) {
        assertDoesNotThrow {
            Cars.withNames(*names.toTypedArray())
        }
    }

    @ParameterizedTest
    @MethodSource("provideNormalCars")
    fun `자동차들 중 우승자를 알아낸다`(cars: Cars, expectedWinners: List<Car>) {
        val winners = cars.getWinners()
        assertThat(winners).isEqualTo(expectedWinners)
    }

    companion object {
        @JvmStatic
        fun provideDuplicatedCarNames(): List<List<String>> {
            return listOf(
                listOf("pobi", "woni", "pobi"),
                listOf("simji", "pobi", "woni", "simji")
            )
        }

        @JvmStatic
        fun provideNormalCarNames(): List<List<String>> {
            return listOf(
                listOf("pobi", "woni", "jun"),
                listOf("simji", "pobi", "woni", "jun")
            )
        }

        @JvmStatic
        fun provideNormalCars(): Stream<Arguments> = Stream.of(
            Arguments.of(
                Cars(
                    listOf(
                        Car("pobi", 0),
                        Car("woni", 1),
                        Car("jun", 3),
                    )
                ),
                listOf(Car("jun", 3))
            ),
            Arguments.of(
                Cars(
                    listOf(
                        Car("pobi", 0),
                        Car("woni", 3),
                        Car("jun", 3),
                    )
                ),
                listOf(
                    Car("woni", 3),
                    Car("jun", 3)
                )
            ),
            Arguments.of(
                Cars(
                    listOf(
                        Car("pobi", 5),
                        Car("woni", 5),
                        Car("jun", 5),
                        Car("simji", 5),
                    )
                ),
                listOf(
                    Car("pobi", 5),
                    Car("woni", 5),
                    Car("jun", 5),
                    Car("simji", 5),
                )
            ),
        )

    }
}
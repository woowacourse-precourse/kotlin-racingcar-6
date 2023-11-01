package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import racingcar.config.ExceptionMessage.DUPLICATED_NAME
import java.util.stream.Stream

class CarsTest {

    @ParameterizedTest
    @MethodSource("provideDuplicatedCars")
    fun `중복된 이름이 있으면 예외를 던진다`(cars: Cars) {
        assertThrows<IllegalArgumentException>(DUPLICATED_NAME) {
            cars.validateDuplicate()
        }
    }

    @ParameterizedTest
    @MethodSource("provideUniqueCars")
    fun `중복된 이름이 없으면 테스트를 통과한다`(cars: Cars) {
        assertDoesNotThrow { cars.validateDuplicate() }
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    fun `가장 큰 position 을 가진 car 의 이름(들)을 리스트로 리턴한다`(data: TestData) {
        val result = data.cars.decideWinner()
        Assertions.assertThat(result).isEqualTo(data.expected)
    }

    companion object {
        @JvmStatic
        fun provideUniqueCars(): Stream<Cars> = Stream.of(
            Cars(listOf(Car("pobi"), Car("woni"), Car("jun"))),
            Cars(listOf(Car("pobi"), Car("woni"), Car("jun"), Car("sh1m"))),
            Cars(listOf(Car("pobi")))
        )

        @JvmStatic
        fun provideDuplicatedCars(): Stream<Cars> = Stream.of(
            Cars(listOf(Car("pobi"), Car("pobi"))),
            Cars(
                listOf(Car("pobi"), Car("woni"), Car("jun"), Car("pobi"))
            ),
            Cars(
                listOf(Car("pobi"), Car("woni"), Car("jun"), Car("jun"))
            )
        )

        @JvmStatic
        fun provideTestData(): Stream<TestData> = Stream.of(
            TestData(
                Cars(
                    listOf(
                        Car("pobi", position = 0),
                        Car("woni", position = 1),
                        Car("jun", position = 2)
                    )
                ),
                listOf("jun")
            ),
            TestData(
                Cars(
                    listOf(
                        Car("pobi", position = 2),
                        Car("woni", position = 2),
                        Car("jun", position = 2)
                    )
                ),
                listOf("pobi", "woni", "jun")
            ),
            TestData(
                Cars(
                    listOf(
                        Car("pobi", position = 0),
                        Car("woni", position = 0),
                        Car("jun", position = 0)
                    )
                ),
                listOf("pobi", "woni", "jun")
            )
        )
    }
}

data class TestData(val cars: Cars, val expected: List<String>)

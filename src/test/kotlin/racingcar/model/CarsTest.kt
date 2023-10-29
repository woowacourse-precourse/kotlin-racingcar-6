package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CarsTest {

    @ParameterizedTest
    @MethodSource("provideCarList")
    fun `자동차 경주 우승자 출력`(carList: List<Car>) {
        val cars = Cars(carList, MoveStep)
        val winners = cars.getWinner()
        assertThat(winners).containsAll(listOf("Kim", "Park", "Hong"))
    }

    companion object {
        @JvmStatic
        fun provideCarList(): Stream<Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    Car("Kim", 4),
                    Car("Lee", 3),
                    Car("Park", 4),
                    Car("Choi", 3),
                    Car("Hong", 4),
                )
            )
        )
    }
}
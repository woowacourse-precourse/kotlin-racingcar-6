package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.car.Car
import racingcar.generator.NumberGenerator
import racingcar.model.CarState
import racingcar.model.RaceResult
import racingcar.model.Winner

class RefereeTest {
    private lateinit var scoreGenerator: NumberGenerator
    private lateinit var referee: Referee

    @BeforeEach
    fun setUp() {
        scoreGenerator = object : NumberGenerator {
            override fun generate(): Int {
                return 4
            }
        }
        referee = Referee(1)
    }

    @Test
    fun `심판은 차들의 Race 결과를 판정한다`() {
        val cars = listOf(
            Car("june", scoreGenerator),
            Car("june2", scoreGenerator)
        )
        val initialRaceResult = referee.determineRaceResult(cars)
        cars.forEach { car -> car.move() }
        val oneStepRaceResult = referee.determineRaceResult(cars)

        assertThat(initialRaceResult).isEqualTo(
            RaceResult(
                listOf(
                    CarState("june", ""),
                    CarState("june2", "")
                )
            )
        )
        assertThat(oneStepRaceResult).isEqualTo(
            RaceResult(
                listOf(
                    CarState("june", "-"),
                    CarState("june2", "-")
                )
            )
        )
    }

    @Test
    fun `심판은 Race의 winner를 판정한다`() {
        val cars = listOf(
            Car("june", scoreGenerator),
            Car("june2", scoreGenerator)
        )
        val noWinner = referee.determineWinner(cars)
        cars.forEach { car -> car.move() }
        val winner = referee.determineWinner(cars)

        assertThat(noWinner.toString())
            .isEqualTo(
                Winner(listOf()).toString()
            )
        assertThat(winner.toString()).isEqualTo(
            Winner(
                listOf(
                    Car("june", scoreGenerator),
                    Car("june2", scoreGenerator)
                )
            ).toString()
        )
    }
}
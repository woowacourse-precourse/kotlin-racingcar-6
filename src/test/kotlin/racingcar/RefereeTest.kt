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
    fun `score가 4 이상이여야 차가 움직일 수 있다`() {
        val referee = Referee(4)

        val movable1 = referee.canCarMove(4)
        val movable2 = referee.canCarMove(3)

        assertThat(movable1).isTrue()
        assertThat(movable2).isFalse()
    }

    @Test
    fun `심판은 차들의 Race 결과를 판정한다`() {
        val cars = listOf(
            Car("june", scoreGenerator),
            Car("june2", scoreGenerator)
        )
        cars.forEach { car -> car.move() }
        val raceResult = referee.determineRaceResult(cars)

        assertThat(raceResult).isEqualTo(
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
        cars.forEach { car -> car.move() }
        val winner = referee.determineWinner(cars)

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
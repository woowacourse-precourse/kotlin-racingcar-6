package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.car.Car
import racingcar.generator.NumberGenerator
import racingcar.model.CarState
import racingcar.model.RaceResult
import racingcar.model.Winner

class RaceTest {
    private lateinit var race: Race
    private lateinit var scoreGenerator: NumberGenerator

    @BeforeEach
    fun setUp() {
        scoreGenerator = object : NumberGenerator {
            override fun generate(): Int {
                return 4
            }
        }
        val scoreGenerator2 = object : NumberGenerator {
            override fun generate(): Int {
                return 3
            }
        }
        val cars = listOf(Car("june", scoreGenerator), Car("pobi", scoreGenerator2))
        race = Race(1, cars)
    }

    @Test
    fun `레이스를 1step 진행한 후, 레이스 결과를 반환`() {
        val result = race.runOneStep()

        assertThat(result).isEqualTo(
            RaceResult(
                listOf(
                    CarState("june", "-"),
                    CarState("pobi", "")
                )
            )
        )
    }

    @Test
    fun `현재 레이싱의 우승자를 반환`() {
        val emptyWinner = race.winner
        race.runOneStep()
        val winner = race.winner

        assertThat(emptyWinner).isEqualTo(Winner(listOf()))
        assertThat(winner.toString()).isEqualTo(Winner(listOf(Car("june", scoreGenerator))).toString())
    }

    @Test
    fun `현재 레이싱이 진행하고 있는지 반환`() {
        val isRunning1 = race.isRunning
        race.runOneStep()
        val isRunning2 = race.isRunning

        assertThat(isRunning1).isTrue()
        assertThat(isRunning2).isFalse()
    }
}
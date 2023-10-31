package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CarsTest {
    private lateinit var cars: Cars

    @Test
    fun `중복된 이름이 있으면 예외를 던진다`() {
        cars = Cars(listOf(Car("pobi"), Car("woni"), Car("jun"), Car("pobi")))
        assertThrows<IllegalArgumentException>(
            "차에 중복된 이름이 있습니다."
        ) {
            cars.validateDuplicate()
        }
    }

    @Test
    fun `중복된 이름이 없으면 테스트를 통과한다`() {
        cars = Cars(listOf(Car("pobi"), Car("woni"), Car("jun")))
        assertDoesNotThrow { cars.validateDuplicate() }
    }

    @Test
    fun `cars 들 중 가장 큰 position 을 가진 car 가 하나이면 그 이름을 리턴한다`() {
        cars = Cars(
            listOf(
                Car("pobi", position = 0),
                Car("woni", position = 1),
                Car("jun", position = 2)
            )
        )
        val result = cars.decideWinner()
        Assertions.assertThat(result).isEqualTo(listOf("jun"))
    }

    @Test
    fun `cars 들 중 가장 큰 position 을 가진 car 가 여럿이면 그 이름들을 리턴한다`() {
        cars = Cars(
            listOf(
                Car("pobi", position = 2),
                Car("woni", position = 2),
                Car("jun", position = 2)
            )
        )
        val result = cars.decideWinner()
        Assertions.assertThat(result).isEqualTo(listOf("pobi", "woni", "jun"))
    }

    @Test
    fun `cars 들의 position 이 모두 0 이면 모든 이름을 리턴한다`() {
        cars = Cars(
            listOf(
                Car("pobi", position = 0),
                Car("woni", position = 0),
                Car("jun", position = 0)
            )
        )
        val result = cars.decideWinner()
        Assertions.assertThat(result).isEqualTo(listOf("pobi", "woni", "jun"))
    }

}
package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class RacingCarsTest {
    @Test
    fun `이름들로 생성실패_2개 미만의 차 이름이 입력됨`() {
        assertThrows<IllegalArgumentException> { RacingCars.fromNames(mutableListOf("pobi")) }
    }

    @Test
    fun `이름들로 생성성공`() {
        assertDoesNotThrow { RacingCars.fromNames(mutableListOf("pobi", "woni")) }
    }

    @Test
    fun `차들로 생성실패_2개 미만의 차들이 입력됨`() {
        assertThrows<IllegalArgumentException> { RacingCars.fromCars(mutableListOf(RacingCar("pobi"))) }
    }

    @Test
    fun `차들로 생성성공`() {
        assertDoesNotThrow { RacingCars.fromCars(mutableListOf(RacingCar("pobi"), RacingCar("woni"))) }
    }

    @Test
    fun `우승자찾기_단독우승자임`() {
        val firstPlace = RacingCar("pobi", 1)
        val secondPlace = RacingCar("woni", 0)
        val racingCars = RacingCars.fromCars(listOf(firstPlace, secondPlace))

        val winners = racingCars.findWinners()

        assertThat(winners).isEqualTo(listOf(firstPlace))
    }

    @Test
    fun 우승자찾기_공동우승자임() {
        val firstPlace = RacingCar("pobi", 1)
        val secondPlace = RacingCar("woni", 1)
        val racingCars = RacingCars.fromCars(listOf(firstPlace, secondPlace))

        val winners = racingCars.findWinners()

        assertThat(winners).isEqualTo(listOf(firstPlace, secondPlace))
    }
}
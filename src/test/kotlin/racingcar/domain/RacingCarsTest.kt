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
    fun `toString_차 3대 상황`() {
        val pobi = RacingCar("pobi", 2)
        val woni = RacingCar("woni", 4)
        val jun = RacingCar("jun", 3)
        val racingCars = RacingCars.fromCars(listOf(pobi, woni, jun))

        assertThat(racingCars.toString()).isEqualTo(
            """
            pobi : --
            woni : ----
            jun : ---
            """.trimIndent()
        )
    }
}
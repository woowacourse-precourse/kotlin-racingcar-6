package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class RacingCarsTest {
    @Test
    fun `생성실패_2개 미만의 차 이름이 입력됨`() {
        assertThrows<IllegalArgumentException> { RacingCars(mutableListOf("pobi")) }
    }

    @Test
    fun 생성성공() {
        assertDoesNotThrow { RacingCars(mutableListOf("pobi", "woni")) }
    }
}
package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class RacingCarTest {
    @Test
    fun `생성실패_이름이 1자 미만임`() {
        assertThrows<IllegalArgumentException> { RacingCar("") }
    }

    @Test
    fun `생성실패_이름이 5자를 초과함`() {
        assertThrows<IllegalArgumentException> { RacingCar("Kennen") }
    }

    @Test
    fun `생성실패_공백 제거 후 이름이 1자 미만임`() {
        assertThrows<IllegalArgumentException> { RacingCar("   ") }
    }

    @Test
    fun 생성성공() {
        assertDoesNotThrow { RacingCar("pobi") }
    }

    @Test
    fun `생성성공_공백 제거 후 4자가 됨`() {
        assertDoesNotThrow { RacingCar("  pobi  ") }
    }
}
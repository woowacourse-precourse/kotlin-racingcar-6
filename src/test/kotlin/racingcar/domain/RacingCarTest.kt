package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
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

    @Test
    fun `이동_랜덤값이 3이하일 경우 멈춤`() {
        val racingCar = RacingCar("pobi")

        racingCar.move(3)

        assertThat(racingCar.getPosition()).isEqualTo(0)
    }

    @Test
    fun `이동_랜덤값이 4이상일 경우 전진`() {
        val racingCar = RacingCar("pobi")

        racingCar.move(4)

        assertThat(racingCar.getPosition()).isEqualTo(1)
    }
}
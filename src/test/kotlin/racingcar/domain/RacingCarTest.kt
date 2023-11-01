package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class RacingCarTest {
    @Test
    fun 생성성공() {
        assertDoesNotThrow { RacingCar("pobi") }
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

    @Test
    fun `toString_이름이 pobi이고 0칸에 위치`() {
        val racingCar = RacingCar("pobi")

        assertThat(racingCar.toString()).isEqualTo("pobi : ")
    }

    @Test
    fun `toString_이름이 woni이고 4칸에 위치`() {
        val racingCar = RacingCar("woni", 4)

        assertThat(racingCar.toString()).isEqualTo("woni : ----")
    }
}